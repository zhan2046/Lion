package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object SouthPark {

    private const val ID = 5503
    private const val PLAY_COUNT = "7"

    private const val TITLE = "南方公园 South Park"
    private const val TAG = "动画·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/south-park.jpg"

    private const val DESC = "美国喜剧中心（ComedyCentral）制作的一部剪纸百拍动画剧集，由MattStone和TreyParker创作。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/south-park01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "1997年首播，至今已播到第14季(2010)。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/south-park02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "主角为科罗拉多州虚构的南方公园小镇的四名8岁的男孩。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "南方公园经常通过歪曲式的摹仿来讽刺和嘲弄美国文化和社会时事的方方面面，挑战了许多根深蒂固的观念和禁忌。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、南方公园", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2921935&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、南方公园", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=3065702&page=1"))

        videoList.add(Video((ID + 13).toString(),
                "3、南方公园", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=3102059&page=1"))

        videoList.add(Video((ID + 14).toString(),
                "4、南方公园", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=3212898&page=1"))

        videoList.add(Video((ID + 15).toString(),
                "5、南方公园", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=3248992&page=1"))

        videoList.add(Video((ID + 16).toString(),
                "6、南方公园", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=3325734&page=1"))

        videoList.add(Video((ID + 17).toString(),
                "7、南方公园", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=3364729&page=1"))

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
