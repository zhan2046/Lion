package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheFarthest {

    private const val ID = 5803
    private const val PLAY_COUNT = "1"

    private const val TITLE = "最远的地方 The Farthest"
    private const val TAG = "社会·科技·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest.jpg"

    private const val DESC = "口碑不错的宇宙纪录片 The Farthest 2017，重现了“旅行者”计划探宇宙的故事，带你去到宇宙尽头。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "1977年，美国发射了旅行者1号和2号，进入太阳系边界，收集木星、土星、天王星、海王星的信息。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-farthest02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "除了采访参与计划的科学家，也去访问了那些代表人类把来自地球的问候刻录在唱片上的人们。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "片中大量来自宇宙深处的照片，令人不得不感叹科学的伟大和迷人之处。", ""))

        videoList.add(Video((ID + 11).toString(),
                "最远的地方 The Farthest (2017)", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=28495352&page=1"))

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
