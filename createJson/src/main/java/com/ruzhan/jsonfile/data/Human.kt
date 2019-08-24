package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object Human {

    private const val ID = 603
    private const val PLAY_COUNT = "1"

    private const val TITLE = "纪录片《HUMAN》"
    private const val TAG = "纪录片·社会"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/human-logo.png"

    private const val DESC = "走访全球60个国家，让2,020位不同肤色、种族、性别的人，在镜头前诉说自己的故事。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/human-img01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "每个人背后都有一个足以撼动心灵的故事。法国知名的摄影师Yann Arthus-Bertrand就用了3年的时间。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/human-img02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "由乌克兰的自由战士、马里的农民，到美国的死囚，各人的故事集结成一部纪录片《HUMAN》。", ""))

        videoList.add(Video((ID + 11).toString(),
                "【纪录片】Human.2015.人类", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=7534518&cid=12337139&page=1"))

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
