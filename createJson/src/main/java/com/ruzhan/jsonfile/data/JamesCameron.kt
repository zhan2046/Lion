package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object JamesCameron {

    private const val ID = 4703
    private const val PLAY_COUNT = "6"

    private const val TITLE = "詹姆斯·卡梅隆的科幻故事"
    private const val TAG = "科幻电影·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron.jpg"

    private const val DESC = "詹姆斯·卡梅隆将通过分析科幻小说从起初被人们崇拜到如今轰动影视界的成功演变，深度探究人类与科幻小说之间的历史关系及现实意义。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "AMC宣布立项科幻小说历史纪录剧集《詹姆斯·卡梅隆的科幻小说轶事》。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/james-cameron02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "詹姆斯·卡梅隆将担任执行制片人。该剧将于2018年上线AMC，共6集。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、第一集 外星生命", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=24026520&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集 外太空", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=24026520&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集 怪物", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=24026520&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、第四集 黑暗未来", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=24026520&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、第五集 智能机器", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=24026520&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、第六集 时间旅行", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=24026520&page=6"))


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
