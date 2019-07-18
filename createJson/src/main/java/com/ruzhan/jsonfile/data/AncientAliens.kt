package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

/**
 * Created by ruzhan123 on 2018/7/3.
 */
object AncientAliens {

    private val ID = 403
    private val PLAY_COUNT = "6"

    private val TITLE = "远古外星人系列 第一季"
    private val TAG = "科教·自然·神秘纪录片"

    private val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ancientalien.jpg"

    private val DESC = "远古外星人是一个美国电视系列，由普罗米修斯娱乐制作，于2010年4月20日在历史频道首播，至2018年已播放第13季。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "主要讲述假设在古代有外星人探访，验证古代宇航员理论。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "远古洞穴壁画中奇异的生物，秘鲁的飞机跑道遗迹，和印第安文字中所描述的“神的飞行器”这些反常的考古文物只是一小部分被von Daniken引用作为远古外星宇航员早已被我们的祖先所熟知的例证。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/ancientalien01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "根据历史文献，考古，传说，探访过去人类与外星人接触的证据。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1，战车，众神和太空·Chariots, Gods and Beyond", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2，证据·The Evidence", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3，天外来客·The Visitors", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4，使命·The Mission", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5，亲密接触·Closer Encounters", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6，回归·The Return", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=2379517&cid=3721214&page=6"))


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
