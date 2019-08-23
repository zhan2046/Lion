package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object WeGotNext {

    private const val ID = 1303
    private const val PLAY_COUNT = "1"

    private const val TITLE = "We Got Next 户外篮球纪录片"
    private const val TAG = "篮球训练·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/we-got-next.jpg"

    private const val DESC = "《体育画报》五人组奔赴美国20天，只为探索一个美国街头篮球的真相。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/we-got-next01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "接下来的36分钟，让我们一起踏上美国最传奇的球场，与传奇对话。愿36分钟后，当你重新投出手中的篮球，感觉从此不同。", ""))

        videoList.add(Video((ID + 11).toString(),
                "We Got Next 户外篮球纪录片", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=26016313&cid=44583561&page=1"))

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
