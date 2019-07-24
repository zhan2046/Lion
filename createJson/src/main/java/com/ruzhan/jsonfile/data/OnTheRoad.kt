package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object OnTheRoad {

    private const val ID = 503
    private const val PLAY_COUNT = "11"

    private const val TITLE = "旅游《张梁记》"
    private const val TAG = "人物·探险·旅游"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ontheroad.jpg"

    private const val DESC = "张昕宇、梁红打造的网络自制户外真人秀节目。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ontheroad01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "2016年5月24日，与汽车之家合作《张梁记》", ""))

        videoList.add(Video((ID + 11).toString(),
                "1", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=18138639&cid=29612554&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=35898881&cid=63002452&page=1"))

        videoList.add(Video((ID + 13).toString(),
                "3", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=29387139&cid=51077136&page=1"))

        videoList.add(Video((ID + 11).toString(),
                "1，再出发 时隔八年重回5·12地震遗址", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2，西部慢调之初涉高原", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3，海拔5231米胜利会师", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4，深入无人区，夜宿羌塘", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5，可可西里的守护者", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6，可可西里祭英魂！", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7，无人区惊现非法闯入者", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=7"))

        videoList.add(Video((ID + 18).toString(),
                "8，梦圆罗布泊", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=8"))

        videoList.add(Video((ID + 19).toString(),
                "9、番外篇—出发前的准备", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=9"))

        videoList.add(Video((ID + 20).toString(),
                "10、番外篇二无人区越野技巧", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=10"))

        videoList.add(Video((ID + 21).toString(),
                "11、“路，一直在”——《张梁记》粉丝见面会", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=5010866&cid=33442775&page=11"))

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
