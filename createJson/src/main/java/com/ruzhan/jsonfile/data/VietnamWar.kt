package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object VietnamWar {

    private const val ID = 5903
    private const val PLAY_COUNT = "1"

    private const val TITLE = "越南战争"
    private const val TAG = "纪录片·战争"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war.jpg"

    private const val DESC = "越南战争纪录片"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "采访了来自各方的近80名亲历者，既有参战与反战的美国人，也有南越与北越的军民。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/vietnam-war02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "本片历经十年制作，跨遍全球搜集资料，其中有许多少见和重新数字化的影像档案，", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "还有20世纪最为出名的摄影照片和家庭影视，以及历史新闻片段和政府内部的秘密录音。", ""))

        videoList.add(Video((ID + 11).toString(),
                "越南战争.3跨越冥河", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=20406207&page=1"))

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
