package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object KeJi {

    private const val ID = 1003
    private const val PLAY_COUNT = "1"

    private const val TITLE = "柯基族人大哥给这个世界的警告"
    private const val TAG = "科教·自然·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/keji.jpg"

    private const val DESC = "哥伦比亚柯基族人的纪录片，非常珍贵，它讲述惟一还保留着前哥伦布时代灵性传统的印第安人部落。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/keji01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "懂得万物恒定之法的高基族人，不仅依然保留着古老传统，并且知道如何在这个工业世界上生存下去。", ""))

        videoList.add(Video((ID + 11).toString(),
                "柯基族人大哥给这个世界的警告", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=26016095&cid=44583119&page=1"))


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
