@file:JvmName("MathUtils")

package com.ruzhan.lion.util

fun constrain(min: Float, max: Float, v: Float) = v.coerceIn(min, max)
