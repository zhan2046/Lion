package com.ruzhan.jsonfile.model

class MovieDetail {

    var id: String? = null
    var movieId: String? = null
    var title: String? = null
    var tag: String? = null
    var desc: String? = null
    var image: String? = null

    var introduces = ArrayList<Introduce>()
    var videos = ArrayList<Video>()
}
