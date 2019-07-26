package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheLieWeLive {

    private const val ID = 1103
    private const val PLAY_COUNT = "1"

    private const val TITLE = "我们身处的谎言世界"
    private const val TAG = "社会·励志片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/lie-we-live.jpg"

    private const val DESC = "YouTube的2015年思想颠覆励志片，预设共28种语言，点击率达到八百多万次数。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/lie-we-live01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "该片重点地完整引述了一系列社会问题丶环境保护丶大自然、全球化和阴谋论，以及未来展望对人类的觉醒作为剧终。", ""))

        videoList.add(Video((ID + 11).toString(),
                "我们身处的谎言世界", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=4472396&cid=7247511&page=1"))


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
