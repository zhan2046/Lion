package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object RunningWild {

    private const val ID = 2503
    private const val PLAY_COUNT = "6"

    private const val TITLE = "越野千里 第一季"
    private const val TAG = "野外·冒险·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/running-wild.jpg"

    private const val DESC = "Bear Grylls全新打造的野外生存的真人秀。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/running-wild01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "贝爷每集将会伙同一位名人，在野外生活48小时。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "名人们将在卡茨基尔山进行空中杂技跳伞，在犹他州用吊绳垂降悬崖，并且在苏格兰高地对抗狂风和暴雨。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921842&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921843&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921844&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921845&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、第五集", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921846&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、第六集", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=2508799&cid=3921847&page=6"))

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
