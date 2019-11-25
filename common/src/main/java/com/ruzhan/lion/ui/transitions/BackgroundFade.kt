package com.ruzhan.lion.ui.transitions

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.transition.TransitionValues
import android.transition.Visibility
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Keep
import com.ruzhan.lion.util.ViewUtils


class BackgroundFade @Keep constructor(context: Context, attrs: AttributeSet) : Visibility(context, attrs) {

    override fun onAppear(sceneRoot: ViewGroup, view: View?,
                          startValues: TransitionValues, endValues: TransitionValues): Animator? {
        if (view == null || view.background == null) return null
        val background = view.background
        background.alpha = 0
        return ObjectAnimator.ofInt(background, ViewUtils.DRAWABLE_ALPHA, 0, 255)
    }

    override fun onDisappear(sceneRoot: ViewGroup, view: View?,
                             startValues: TransitionValues, endValues: TransitionValues): Animator? {
        return if (view == null || view.background == null) null else
            ObjectAnimator.ofInt(view.background, ViewUtils.DRAWABLE_ALPHA, 0)
    }
}

