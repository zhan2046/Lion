package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheSecret {

    private const val ID = 703
    private const val PLAY_COUNT = "1"

    private const val TITLE = "秘密《吸引力法则》"
    private const val TAG = "纪录片·人文·历史"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-secret-logo.jpg"

    private const val DESC = "吸引力法则是新思维运动的一种概念，认为人际关系可通过正面或负面想法，从而得到正面或负面的结果。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                "吸引定律又称“吸引力法则”，指思想集中在某一领域的时候，跟这个领域相关的人、事、物就会被他吸引而来。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-secret-img01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "有一种我们看不见的能量，一直引导着整个宇宙规律性的运转，正是因为它的作用地球才能够在46亿年的时间里保持着运转的状态。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "也正是因为它的作用，太阳系乃至整个宇宙中，数以亿计的星球，都能相安无事的停留在各自的轨道上安分地运行", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "这样一种能量引导着宇宙中的每一样事物，也引导着我们的生活，这种能量就是——吸引力。", ""))

        videoList.add(Video((ID + 11).toString(),
                "吸引力法则", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=2691104&cid=4204067&page=1"))

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
