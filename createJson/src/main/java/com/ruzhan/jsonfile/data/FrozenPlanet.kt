package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object FrozenPlanet {

    private const val ID = 4003
    private const val PLAY_COUNT = "8"

    private const val TITLE = "冰冻星球"
    private const val TAG = "纪录片·自然"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet.jpg"

    private const val DESC = "英国BBC电视台耗时5年制作的纪录片《冰冻星球》于近期推出。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "这部耗资巨大的纪录片用镜头真实的展现了正在逐渐溶解的地球两极，以及生活在这里的各种生物，片中种种景象让人叹为观止。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/frozen-planet02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "《冰冻星球》为英国广播公司与探索频道及英国公开大学联合制作的自然纪录片，由大卫·爱登堡旁白。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "2011年10月26日起于英国广播公司第一台及高清频道首播，共7集。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "本片主要展示栖息于北极和南极的动植物及其生境，而第7集则探讨全球暖化对极地以至全球的影响，由大卫·爱登堡联同科学家亲身于极地考察及解说。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、BBC.Frozen.Planet.EP01.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=26338600&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、BBC.Frozen.Planet.EP02.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=26338600&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、BBC.Frozen.Planet.EP03.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=26338600&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、BBC.Frozen.Planet.EP04.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=26338600&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、BBC.Frozen.Planet.EP05.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=26338600&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、BBC.Frozen.Planet.EP06.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=26338600&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、BBC.Frozen.Planet.EP07.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=26338600&page=7"))

        videoList.add(Video((ID + 18).toString(),
                "8、BBC.Frozen.Planet.EP08.2011.BluRay.Repack.1080p", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=26338600&page=8"))

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
