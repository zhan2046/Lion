package com.ruzhan.movie.model

data class Introduce(
        var type: Int,
        var text: String,
        var image: String
) {
    companion object {

        const val TEXT = 1000
        const val IMAGE = 1001
    }
}