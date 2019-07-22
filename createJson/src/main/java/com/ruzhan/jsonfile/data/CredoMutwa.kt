package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object CredoMutwa {

    private const val ID = 803
    private const val PLAY_COUNT = "7"

    private const val TITLE = "1999年 地球史上最震撼的访谈"
    private const val TAG = "社会·神秘纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/credo-mutwa01.jpg"

    private const val DESC = "来自非洲的 科瑞多·穆特瓦(Credo Mutwa)，分享古老非洲保存下来的知识。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "也许全世界需要知道这些！”. ...是时候了。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/credo-mutwa.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "他是祖鲁族(古代官方)故事的指定叙述人,同时也是历史知识的保管者，他掌握着惊世秘密，他曾面临各方威胁，为此付出巨大代价，而幕后只是人只想让他永远闭嘴。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "1999年著名记者大卫·艾克在南非约翰内斯堡秘密访谈了科瑞多。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、地球史上最震撼的访谈(一)", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、地球史上最震撼的访谈(二)", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、地球史上最震撼的访谈(三)", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、地球史上最震撼的访谈(四)", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、地球史上最震撼的访谈(五)", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、地球史上最震撼的访谈(六)", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、地球史上最震撼的访谈(七)", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=19969253&cid=32571391&page=7"))

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
