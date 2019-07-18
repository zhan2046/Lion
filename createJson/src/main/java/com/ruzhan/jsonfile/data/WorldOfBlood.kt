package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

/**
 * Created by ruzhan123 on 2018/7/3.
 */
object WorldOfBlood {

    private val ID = 3003
    private val PLAY_COUNT = "1"

    private val TITLE = "血的奇妙世界"
    private val TAG = "BBC·纪录片"

    private val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/world-of-blood.jpg"

    private val DESC = "以高端科研技术，探究血液对人体不可或缺的作用。究竟这些红色的黏稠液体，如何帮助我们维系生命？"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/world-of-blood01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "血液是人类维系生命的重要元素，与生活息息相关，而成人的血液约占体重十分之一。", ""))

        videoList.add(Video((ID + 11).toString(),
                "血的奇妙世界", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=14197644&cid=23173764&page=1"))


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
