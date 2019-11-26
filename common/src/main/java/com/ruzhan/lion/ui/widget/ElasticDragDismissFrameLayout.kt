package com.ruzhan.lion.ui.widget

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

import androidx.constraintlayout.widget.ConstraintLayout

import com.ruzhan.common.R
import com.ruzhan.lion.listener.ElasticDragDismissCallback
import com.ruzhan.lion.util.AnimUtils
import com.ruzhan.lion.util.ColorUtils
import com.ruzhan.lion.util.ViewUtils

import java.util.ArrayList
import kotlin.math.abs
import kotlin.math.log10

class ElasticDragDismissFrameLayout : ConstraintLayout {

    private var dragDismissDistance = java.lang.Float.MAX_VALUE
    private var dragDismissFraction = -1f
    private var dragDismissScale = 1f
    private var shouldScale = false
    private var dragElacticity = 0.8f

    private var totalDrag: Float = 0.toFloat()
    private var draggingDown = false
    private var draggingUp = false
    private var mLastActionEvent: Int = 0

    private var callbacks: MutableList<ElasticDragDismissCallback>? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet) {
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.ElasticDragDismissFrameLayout, 0, 0)

        if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissDistance)) {
            dragDismissDistance = a.getDimensionPixelSize(R.styleable
                    .ElasticDragDismissFrameLayout_dragDismissDistance, 0).toFloat()
        } else if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissFraction)) {
            dragDismissFraction = a.getFloat(R.styleable
                    .ElasticDragDismissFrameLayout_dragDismissFraction, dragDismissFraction)
        }
        if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragDismissScale)) {
            dragDismissScale = a.getFloat(R.styleable
                    .ElasticDragDismissFrameLayout_dragDismissScale, dragDismissScale)
            shouldScale = dragDismissScale != 1f
        }
        if (a.hasValue(R.styleable.ElasticDragDismissFrameLayout_dragElasticity)) {
            dragElacticity = a.getFloat(R.styleable.ElasticDragDismissFrameLayout_dragElasticity,
                    dragElacticity)
        }
        a.recycle()
    }

    override fun onStartNestedScroll(child: View, target: View, nestedScrollAxes: Int): Boolean {
        return nestedScrollAxes and View.SCROLL_AXIS_VERTICAL != 0
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray) {
        if (draggingDown && dy > 0 || draggingUp && dy < 0) {
            dragScale(dy)
            consumed[1] = dy
        }
    }

    private fun dragScale(scroll: Int) {
        if (scroll == 0) return
        totalDrag += scroll.toFloat()

        if (scroll < 0 && !draggingUp && !draggingDown) {
            draggingDown = true
            if (shouldScale) pivotY = height.toFloat()
        } else if (scroll > 0 && !draggingDown && !draggingUp) {
            draggingUp = true
            if (shouldScale) pivotY = 0f
        }
        var dragFraction = log10((1 + abs(totalDrag) / dragDismissDistance)
                .toDouble()).toFloat()
        var dragTo = dragFraction * dragDismissDistance * dragElacticity

        if (draggingUp) {
            dragTo *= -1f
        }
        translationY = dragTo

        if (shouldScale) {
            val scale = 1 - (1 - dragDismissScale) * dragFraction
            scaleX = scale
            scaleY = scale
        }
        if (draggingDown && totalDrag >= 0 || draggingUp && totalDrag <= 0) {
            dragFraction = 0f
            dragTo = dragFraction
            totalDrag = dragTo
            draggingUp = false
            draggingDown = draggingUp
            translationY = 0f
            scaleX = 1f
            scaleY = 1f
        }
        dispatchDragCallback(dragFraction, dragTo,
                1f.coerceAtMost(abs(totalDrag) / dragDismissDistance), totalDrag)
    }

    private fun dispatchDragCallback(elasticOffset: Float, elasticOffsetPixels: Float,
                                     rawOffset: Float, rawOffsetPixels: Float) {
        if (callbacks != null && callbacks!!.isNotEmpty()) {
            for (callback in callbacks!!) {
                callback.onDrag(elasticOffset, elasticOffsetPixels,
                        rawOffset, rawOffsetPixels)
            }
        }
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int,
                                dxUnconsumed: Int, dyUnconsumed: Int) {
        dragScale(dyUnconsumed)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        mLastActionEvent = ev.action
        return super.onInterceptTouchEvent(ev)
    }

    override fun onStopNestedScroll(child: View) {
        if (abs(totalDrag) >= dragDismissDistance) {
            dispatchDismissCallback()
        } else {
            if (mLastActionEvent == MotionEvent.ACTION_DOWN) {
                translationY = 0f
                scaleX = 1f
                scaleY = 1f
            } else {
                animate()
                        .translationY(0f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200L)
                        .setInterpolator(AnimUtils.getFastOutSlowInInterpolator(context))
                        .setListener(null)
                        .start()
            }
            totalDrag = 0f
            draggingUp = false
            draggingDown = draggingUp
            dispatchDragCallback(0f, 0f, 0f, 0f)
        }
    }

    private fun dispatchDismissCallback() {
        if (callbacks != null && callbacks!!.isNotEmpty()) {
            for (callback in callbacks!!) {
                callback.onDragDismissed()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (dragDismissFraction > 0f) {
            dragDismissDistance = h * dragDismissFraction
        }
    }

    fun addListener(listener: ElasticDragDismissCallback) {
        if (callbacks == null) {
            callbacks = ArrayList()
        }
        callbacks!!.add(listener)
    }

    fun removeListener(listener: ElasticDragDismissCallback) {
        if (callbacks != null && callbacks!!.size > 0) {
            callbacks!!.remove(listener)
        }
    }

    open class SystemChromeFader(private val activity: Activity) : ElasticDragDismissCallback {
        private val statusBarAlpha: Int = Color.alpha(activity.window.statusBarColor)
        private val navBarAlpha: Int = Color.alpha(activity.window.navigationBarColor)
        private val fadeNavBar: Boolean = ViewUtils.isNavBarOnBottom(activity)

        override fun onDrag(elasticOffset: Float, elasticOffsetPixels: Float,
                            rawOffset: Float, rawOffsetPixels: Float) {
            if (elasticOffsetPixels > 0) {
                activity.window.statusBarColor = ColorUtils.modifyAlpha(activity.window
                        .statusBarColor, ((1f - rawOffset) * statusBarAlpha).toInt())
            } else if (elasticOffsetPixels == 0f) {
                activity.window.statusBarColor = ColorUtils.modifyAlpha(
                        activity.window.statusBarColor, statusBarAlpha)
                activity.window.navigationBarColor = ColorUtils.modifyAlpha(
                        activity.window.navigationBarColor, navBarAlpha)
            } else if (fadeNavBar) {
                activity.window.navigationBarColor =
                        ColorUtils.modifyAlpha(activity.window.navigationBarColor,
                        ((1f - rawOffset) * navBarAlpha).toInt())
            }
        }

        override fun onDragDismissed() {
            activity.finishAfterTransition()
        }
    }
}
