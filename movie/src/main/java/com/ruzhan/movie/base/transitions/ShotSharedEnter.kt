package com.ruzhan.movie.base.transitions

import android.content.Context
import android.graphics.Rect
import android.transition.ChangeBounds
import android.transition.TransitionValues
import android.util.AttributeSet
import android.view.View


class ShotSharedEnter(context: Context, attrs: AttributeSet) : ChangeBounds(context, attrs) {

    override fun captureEndValues(transitionValues: TransitionValues) {
        super.captureEndValues(transitionValues)
        val width = (transitionValues.values[PROPNAME_PARENT] as View).width
        val bounds = transitionValues.values[PROPNAME_BOUNDS] as Rect
        bounds.right = width
        bounds.bottom = width * 9 / 16
        transitionValues.values[PROPNAME_BOUNDS] = bounds
    }

    companion object {

        private const val PROPNAME_BOUNDS = "android:changeBounds:bounds"
        private const val PROPNAME_PARENT = "android:changeBounds:parent"
    }
}