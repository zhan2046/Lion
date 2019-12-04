package com.ruzhan.movie.listener

interface ElasticDragDismissCallback {

    fun onDrag(elasticOffset: Float, elasticOffsetPixels: Float,
               rawOffset: Float, rawOffsetPixels: Float)

    fun onDragDismissed()
}
