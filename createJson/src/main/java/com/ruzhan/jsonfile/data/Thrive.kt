package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object Thrive {

    private const val ID = 3103
    private const val PLAY_COUNT = "1"

    private const val TITLE = "Thrive《兴盛》"
    private const val TAG = "社会揭露·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive.jpg"

    private const val DESC = "通过追踪经济发展而揭开世界运作方式，并涵盖影响我们生命的各种力量面纱的，非常规型纪录电影。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/thrive01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "把科学领域的突破与觉察、行动编织在一起，《兴盛》提供给我们真正的解决方法。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "使我们能够用史无前例地、无畏地战略来改造我们的生活和我们的未来。", ""))

        videoList.add(Video((ID + 11).toString(),
                "Thrive《兴盛》", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=3818950&cid=6133682&page=1"))

        movie.id = ID.toString()
        movie.title = TITLE
        movie.tag = TAG
        movie.desc = DESC
        movie.image = IMAGE

        movieDetail.id = (ID + 3).toString()
        movieDetail.movieId = ID.toString()
        movieDetail.title = TITLE
        movieDetail.tag = TAG
        movieDetail.desc = DESC
        movieDetail.image = IMAGE

        movieDetail.introduces = ArrayList()
        movieDetail.introduces.addAll(introduceList)

        movieDetail.videos = ArrayList()
        movieDetail.videos.addAll(videoList)
    }
}
