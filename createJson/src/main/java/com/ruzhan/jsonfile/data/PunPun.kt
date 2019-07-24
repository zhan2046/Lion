package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object PunPun {

    private const val ID = 1203
    private const val PLAY_COUNT = "1"

    private const val TITLE = "生活如此简单，为什么让我们变得很复杂"
    private const val TAG = "TED·演讲·公开课"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/punpun.jpg"

    private const val DESC = "一个来自泰国东北部的农民，他与我们分享了他对简单、幸福的生活的理解。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/punpun01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "他成立了一个可持续性生活的Pun Pun中心，而且还在不断努力寻找更简单的方法满足人们的基本需求。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "你那么努力，为什么还活得那么难？一个值得读完的故事，让许多人看完都沉默了….", ""))

        videoList.add(Video((ID + 11).toString(),
                "生活如此简单，为什么让我们变得很复杂", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=4456510&cid=7221659&page=1"))


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
