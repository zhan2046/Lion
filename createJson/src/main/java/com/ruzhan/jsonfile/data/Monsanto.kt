package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object Monsanto {

    private const val ID = 3203
    private const val PLAY_COUNT = "2"

    private const val TITLE = "转基因赌局：用生命下注"
    private const val TAG = "社会揭露·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/monsanto01.jpg"

    private const val DESC = "这部新纪录片对美国孟山都公司的名誉发起了另一轮剧烈冲击。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/monsanto.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "美国孟山都公司是全球最大的化工公司之一，也是全球90%转基因作物的种子技术的提供者。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "这部名为“孟山都公司眼中的世界”的法国纪录片由独立导演Marie-Monique Robin执导，影片为观众展现出一家长期危害环境 、制造卫生健康丑闻的公司的可怕嘴脸。", ""))

        videoList.add(Video((ID + 11).toString(),
                "转基因赌局：用生命下注", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=22137667&cid=36606699&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "智平方辩论-转基因食品是否利大于弊", IMAGE, PLAY_COUNT, 2, "电影",
                "http://player.bilibili.com/player.html?aid=10403428&cid=17181618&page=1"))

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
