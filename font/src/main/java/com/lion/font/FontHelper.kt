package com.lion.font

import android.app.Application
import android.graphics.Typeface

class FontHelper private constructor() {

    private var lightFontTypeface: Typeface
    private var boldFontTypeface: Typeface

    init {
        val application = application
                ?: throw RuntimeException("FontHelper must call init to application onCreate")
        lightFontTypeface = Typeface.createFromAsset(application.assets, TEXT_LIGHT)
        boldFontTypeface = Typeface.createFromAsset(application.assets, TEXT_BOLD)
    }

    companion object {

        const val TEXT_BOLD = "fonts/text_bold.ttf"
        const val TEXT_LIGHT = "fonts/text_light.ttf"

        private var INSTANCE: FontHelper? = null
        private var application: Application? = null

        @JvmStatic
        fun get(): FontHelper = INSTANCE ?: synchronized(FontHelper::class) {
            INSTANCE ?: FontHelper().also { INSTANCE = it }
        }

        @JvmStatic
        fun init(application: Application) {
            this.application = application
        }
    }

    fun getLightTypeface(): Typeface {
        return lightFontTypeface
    }

    fun getBoldTypeface(): Typeface {
        return boldFontTypeface
    }
}