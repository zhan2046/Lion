package com.ruzhan.lion.listener

interface ElasticDragDismissCallback {

    fun onDrag(elasticOffset: Float, elasticOffsetPixels: Float,
               rawOffset: Float, rawOffsetPixels: Float)

    fun onDragDismissed()
}
