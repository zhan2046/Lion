package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object TheStoryOfGod {

    private const val ID = 1703
    private const val PLAY_COUNT = "6"

    private const val TITLE = "摩根费里曼之神的万物论"
    private const val TAG = "国家地理频道·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-story-of-dod.jpg"

    private const val DESC = "国家地理频道《The Story of God with Morgan Freeman》"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-story-of-dod01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "这些永恒及普世的谜团，影响了世上所有拥有信仰的人。摩根在节目中走访许多地方，亲自感受一些重要的宗教体验。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "从耶路撒冷的哭墙、印度的菩提树，到美国的超级教会。他也自告奋勇，充当实验室白老鼠，检视尖端神经科学和宇宙学，跟传统宗教之间的关系。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他也跟考古学家一起探索人类祖先佚失的古老宗教，如土耳其有万年历史的哥贝克力山丘废墟。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "人和神的关系是人类史上最重要的问题，本节目探讨了信仰对我们生活造成的影响。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、第一集：超越死亡", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568901&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集：末日启示", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568902&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集：神为何人", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568897&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、第四集：创世之说", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568898&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、第五集：邪恶之源", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568899&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、第六集：神迹之力", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=11226606&cid=18568900&page=6"))

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
