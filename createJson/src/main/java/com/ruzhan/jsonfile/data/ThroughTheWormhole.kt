package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object ThroughTheWormhole {

    private const val ID = 1503
    private const val PLAY_COUNT = "8"

    private const val TITLE = "摩根费里曼之穿越虫洞"
    private const val TAG = "科教·记录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/through-the-wormhole.jpg"

    private const val DESC = "探讨科学的电视节目，由摩根·费里曼担任旁白及主持人。于美国时间2010年6月9日在科学频道首播。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/through-the-wormhole02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "《摩根费里曼之穿越虫洞》是一部由摩根弗里曼主持的科教纪录片。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "由百老汇演员摩根费里曼特别主持，从摩根费里曼介绍的话语中和作品中他经常出演科学家也能感受到他对天体物理的喜爱，并在节目中阐述世界是由数字组成的，从而成为了节目的“灵魂”。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "节目内容丰富，包括了天文、人文、科学等领域，节目组集结的多位科学家发表自己的意见并互相的反驳争论", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/through-the-wormhole01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "这也是天体物理爱好者的另一项看点，给未来宇宙的探索增长了见识，并给令一些科幻迷们另一些想象的空间。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "每集节目将深入探讨一个重要的谜团，并介绍来自著名机构和研究中心的科学研究，和令人惊奇的专家理论", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "像是美国太空总署、牛津大学、欧洲核子研究组织（简称CERN）、外星生命探测研究所、普林斯顿大学、麻省理工学院和费米国家实验室等等。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、S06E01：我们都是偏执狂？", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=26788497&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、S06E02：时间可以倒流吗？", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=26788497&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、S06E03：我们的存在是有原因的？", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=26788497&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、S06E04：我们生活在矩阵里吗？", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=26788497&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、S06E05：外星人在我们体内吗？", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=26788497&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、S06E06：我们为什么说谎？", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=26788497&page=6"))

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
