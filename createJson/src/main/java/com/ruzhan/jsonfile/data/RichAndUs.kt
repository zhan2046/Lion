package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object RichAndUs {

    private const val ID = 2303
    private const val PLAY_COUNT = "3"

    private const val TITLE = "巨富与我们"
    private const val TAG = "社会揭露·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/eich-and-us.jpg"

    private const val DESC = "一个有关超级土豪的纪录片。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/eich-and-us01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "记者Jacques Peretti走访各种土豪人士、经济学家、平民百姓，研究超级土豪是如何改变了英国。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "这部纪录片揭露出所谓的“下渗式经济”是如果令贫富变得更加悬殊的。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "英国政府为了政绩把本国打造成富人避税天堂，但30多年来所谓的富人涓滴效应并未惠及底层人民，反而随着金融衍生品和次贷危机使贫富差距加剧而形成沙漏社会。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "中产的消亡将进一步削弱资本主义制度。英国如此，世界亦然。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=2989838&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=3029801&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=1931988&cid=2989839&page=3"))

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
