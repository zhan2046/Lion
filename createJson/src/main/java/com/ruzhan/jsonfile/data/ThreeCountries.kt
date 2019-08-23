package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object ThreeCountries {

    private const val ID = 5103
    private const val PLAY_COUNT = "6"

    private const val TITLE = "三国的世界"
    private const val TAG = "纪录片·历史"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries.jpg"

    private const val DESC = "通过讲述“三国”和其中人物的命运故事，传递他们所承载的传续千年的精神力量和文化底蕴，并探寻那段历史中最有价值的精神本源以及它对后世的深刻影响。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "《三国的世界》共分为六集，每集50分钟，分别为《良史演义共三国》《星落秋风五丈原》《横槊悲歌观沧海》《义薄云天垂九州》《一江南北真豪杰》《大江东去意未销》。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/three-countries02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "第一集的主要人物是《三国志》的作者陈寿和《三国演义》的作者罗贯中，以及为《三国志》作注的作者裴松之；第二集的主要人物是蜀相诸葛亮。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "第三集的主要人物是魏武帝曹操；第四集的主要人物是汉寿亭侯关羽。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "第五集是群像，以东吴的孙权、周瑜和鲁肃为主要人物；第六集聚焦三国文化的影响力为何如此普遍、持久。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、1. 大江东去意未销", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=27564550&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、2. 星落秋风五丈原", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=27564550&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、3. 横槊悲歌观沧海", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=27564550&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、4. 义薄云天垂九州", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=27564550&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、5. 一江南北真豪杰", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=27564550&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、6. 良史演义共三国", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=27564550&page=6"))


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
