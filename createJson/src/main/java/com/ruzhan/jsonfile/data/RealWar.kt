package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object RealWar {

    private const val ID = 4903
    private const val PLAY_COUNT = "4"

    private const val TITLE = "真正的权力的游戏:百年战争"
    private const val TAG = "纪录片·历史"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war.jpg"

    private const val DESC = "乔治·R·R·马丁老爷子坦言《冰与火之歌》的创作灵感来自欧洲历史，本片讲述英格兰和法兰西王国之间的百年战争。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "[BBC] 真正的权力的游戏：百年战争 / The.Real.War.Of.Thrones.The.True.History.of.Europe，共4集。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/real-war02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "本记录片讲述英格兰和法兰西王国之间的百年战争。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、百年战争 第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=21579565&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、百年战争 第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=21579565&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、百年战争 第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=21579565&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、百年战争 第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=21579565&page=4"))


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
