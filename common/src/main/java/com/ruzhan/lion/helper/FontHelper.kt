package com.ruzhan.lion.helper

import android.graphics.Typeface
import com.ruzhan.lion.App

class FontHelper private constructor() {

    private var lightFontTypeface: Typeface
    private var boldFontTypeface: Typeface

    init {
        val assetManager = App.get().assets
        lightFontTypeface = Typeface.createFromAsset(assetManager, TEXT_LIGHT)
        boldFontTypeface = Typeface.createFromAsset(assetManager, TEXT_BOLD)
    }

    companion object {

        const val TEXT_BOLD = "fonts/text_bold.ttf"
        const val TEXT_LIGHT = "fonts/text_light.ttf"

        private var INSTANCE: FontHelper? = null

        @JvmStatic
        fun get(): FontHelper {
            if (INSTANCE == null) {
                synchronized(FontHelper::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = FontHelper()
                    }
                }
            }
            return this.INSTANCE!!
        }
    }

    fun getLightTypeface(): Typeface {
        return lightFontTypeface
    }

    fun getBoldTypeface(): Typeface {
        return boldFontTypeface
    }
}