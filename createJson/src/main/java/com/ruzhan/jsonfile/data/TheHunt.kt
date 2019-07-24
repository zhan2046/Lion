package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheHunt {

    private const val ID = 4103
    private const val PLAY_COUNT = "7"

    private const val TITLE = "BBC One - The Hunt"
    private const val TAG = "自然·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt.jpg"

    private const val DESC = "BBC地球部自然纪录片新高度，由冰冻星球制作团队历时3年，跨越30多个国家拍摄完成，拍摄到了很多令人窒息的罕见镜头，“自然纪录片之父”大卫·爱登堡旁白。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "首次披露南美水濑，座头鲸的猎食行为，更借用了电影、戏剧中的片段，力求给观众一个具有说服力的印象。 ", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-hunt02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "摄制组的足迹遍布雨林，冻土层，海洋，草原，极地，典型生态环境一网打尽，还记录了各路科学家以及环保人士对保护濒危动物所做出的努力。 ", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "由《地心引力》的作曲家Steven Price作曲。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "鸟瞰航拍水下特写等极致摄影技术，电影式的剪辑手法和地心引力配乐师作曲，其故事性和悬念性俨然是一部好莱坞大片。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=5607227&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=5607227&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=5607227&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=5607227&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、第五集", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=5607227&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、第六集", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=5607227&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、第七集", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=5607227&page=7"))

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
