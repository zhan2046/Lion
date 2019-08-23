package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object TheOrionConspiracy {

    private const val ID = 903
    private const val PLAY_COUNT = "1"

    private const val TITLE = "猎户座阴谋"
    private const val TAG = "社会揭露·科幻片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy.jpg"

    private const val DESC = "该影片表达的是在时间的考验下，我们也许将会受到自己所作的一切的惩罚，在痛苦中失去生命的本来。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "你知道么，这世界上存在一种造价不超过一台计算机，仅使用水和空气就可以供应一家用电的机器，你未曾听说过，因为这将颠覆那些财团、国家。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "你知道么，我们的文化，价值观，金融系统在奴役你，你要努力工作一生以买一套房子。媒体让我们购买不需要的产品，因为那会让你幸福。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-orion-conspiracy02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "你知道么，这个世界，国家，民族间应该相亲相爱的，而我们整个人类的社会系统都在憎恨，嫉妒。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "也许我们一直生活在一个巨大无比的阴谋下，一无所知，追求幸福，而忘记了造物者的初衷。", ""))

        videoList.add(Video((ID + 11).toString(),
                "猎户座阴谋", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=16189807&cid=26423988&page=1"))

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
