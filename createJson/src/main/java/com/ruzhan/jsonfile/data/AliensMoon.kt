package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object AliensMoon {

    private const val ID = 3403
    private const val PLAY_COUNT = "1"

    private const val TITLE = "Aliens on the Moon"
    private const val TAG = "纪录片·宇宙太空"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/aliens-moon.jpg"

    private const val DESC = "本片揭露有关我们的邻居月球，在月球上曾经有外星人居住，并作为一个星际中转区。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/aliens-moon01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "一个半小时的视频为您展示所有令人震惊的证据:巨大的卫星天线,核电站,巨大的UFO,外星人的太空堡垒,采矿区。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "而NASA把这些证据在一一销毁,上世纪70年代是否还有其它阿波罗号在秘密探月?他们去干什么?", ""))


        videoList.add(Video((ID + 11).toString(),
                "Aliens on the Moon", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=2878263&cid=4497344&page=1"))

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
