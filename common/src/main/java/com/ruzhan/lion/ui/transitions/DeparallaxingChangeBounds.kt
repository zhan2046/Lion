package com.ruzhan.lion.ui.transitions

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Rect
import android.transition.ChangeBounds
import android.transition.TransitionValues
import android.util.AttributeSet
import android.view.ViewGroup

import com.ruzhan.lion.ui.widget.ParallaxScrImageView


class DeparallaxingChangeBounds(context: Context, attrs: AttributeSet) : ChangeBounds(context, attrs) {

    override fun captureEndValues(transitionValues: TransitionValues) {
        super.captureEndValues(transitionValues)
        if (transitionValues.view !is ParallaxScrImageView) return
        val psv = transitionValues.view as ParallaxScrImageView
        if (psv.offset == 0) return

        // as we're going to remove the offset (which drives the parallax) we need to
        // compensate for this by adjusting the target bounds.
        val bounds = transitionValues.values[PROPNAME_BOUNDS] as Rect
        bounds.offset(0, psv.offset)
        transitionValues.values[PROPNAME_BOUNDS] = bounds
    }

    override fun createAnimator(sceneRoot: ViewGroup,
                                startValues: TransitionValues?,
                                endValues: TransitionValues?): Animator {
        val changeBounds = super.createAnimator(sceneRoot, startValues, endValues)
        if (startValues == null || endValues == null
                || endValues.view !is ParallaxScrImageView)
            return changeBounds
        val psv = endValues.view as ParallaxScrImageView
        if (psv.offset == 0) return changeBounds

        val deparallax = ObjectAnimator.ofInt(psv, ParallaxScrImageView.OFFSET, 0)
        val transition = AnimatorSet()
        transition.playTogether(changeBounds, deparallax)
        return transition
    }

    companion object {

        private const val PROPNAME_BOUNDS = "android:changeBounds:bounds"
    }
}
