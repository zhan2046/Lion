package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object DevinWilliams {

    private const val ID = 1403
    private const val PLAY_COUNT = "12"

    private const val TITLE = "篮球训练纪录片10000小时"
    private const val TAG = "篮球训练·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/devin-williams.jpg"

    private const val DESC = "一部篮球训练纪录片。其中的10000小时精神值得所有热爱篮球的人思考。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                "德文·威廉姆斯，在youtube炙手可热的美国训练师和视频剪辑师，创造了篮球纪录片《10000小时》和训练系列片《in the lab》等，实战水平相当高。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/devin-williams01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "谁能想象，一个膝盖有伤，之前完全不会剪辑的街头球手能成为红火于youtube和业余篮球圈的篮球训练师? DW做到了。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "在一个偶然的契机下，他被两个华裔小子缠着教授运球，在反省自己对生活的态度后，他不辞辛劳的帮助兄弟俩matty和kyle训练，从未停歇。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "只要有时间，一周大部分时间，dw都带着兄弟俩练习各种篮球技术和身体训练，不练吐绝不停歇！", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "在见到兄弟俩前，DW正过着不好的生活，他在大学里弄伤了自己的膝盖，对生活颓废，终日以大麻来蒙蔽自己，直到教授这两个华裔孩子，用他自己的话来说就是“我努力的保护着火种”。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "就这样《10000小时》系列诞生了，成为了经典的励志篮球训练纪录片。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2659444&cid=4153257&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=2659816&cid=4153770&page=1"))

        videoList.add(Video((ID + 13).toString(),
                "3，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=2662826&cid=4158697&page=1"))

        videoList.add(Video((ID + 14).toString(),
                "4，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=2673458&cid=4175752&page=1"))

        videoList.add(Video((ID + 15).toString(),
                "5，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=2711840&cid=4236056&page=1"))

        videoList.add(Video((ID + 16).toString(),
                "篮球训练纪录片《10000小时》5.2", IMAGE, PLAY_COUNT, 6, "5.2集",
                "http://player.bilibili.com/player.html?aid=26023215&cid=44601502&page=1"))

        videoList.add(Video((ID + 17).toString(),
                "6，篮球训练纪录片《10000小时》", IMAGE, PLAY_COUNT, 7, "第六集",
                "http://player.bilibili.com/player.html?aid=2717828&cid=4245426&page=1"))

        videoList.add(Video((ID + 18).toString(),
                "篮球训练纪录片《10000小时》6.2", IMAGE, PLAY_COUNT, 8, "6.2集",
                "http://player.bilibili.com/player.html?aid=26023561&cid=44602501&page=1"))

        videoList.add(Video((ID + 19).toString(),
                "7，篮球训练纪录片《10000小时》第七部", IMAGE, PLAY_COUNT, 9, "第七集",
                "http://player.bilibili.com/player.html?aid=26023991&cid=44603241&page=1"))

        videoList.add(Video((ID + 20).toString(),
                "中英字幕10000小时8.1集 归零Back to Zero", IMAGE, PLAY_COUNT, 10, "8.1集",
                "http://player.bilibili.com/player.html?aid=5370407&cid=8730740&page=1"))

        videoList.add(Video((ID + 21).toString(),
                "《10000小时》纪录片 Episode 8.5", IMAGE, PLAY_COUNT, 11, "8.5集",
                "http://player.bilibili.com/player.html?aid=5386553&cid=8756014&page=1"))

        videoList.add(Video((ID + 22).toString(),
                "DulaniRobinson Pt1", IMAGE, PLAY_COUNT, 12, "8.6集",
                "http://player.bilibili.com/player.html?aid=5386553&cid=8756015&page=2"))


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
