package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object TheBleedingEdge {

    private const val ID = 5603
    private const val PLAY_COUNT = "1"

    private const val TITLE = "尖端医疗的真相:你安全吗"
    private const val TAG = "社会揭露·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge.jpg"

    private const val DESC = "探讨美国利益导向，且价值高达数十亿美元的医疗器材产业，如何将风险天天加诸在病患身上。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "Investigative filmmakers Kirby Dick and Amy Ziering present a searing exposé of modern medical devices,", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-bleeding-edge02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                " a billion dollar industry whose technological advancements have lead to unparalleled innovations,", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "yet is rife with lax regulations, corporate cover-ups, and profit driven incentives that have lead to deadly risks for unsuspecting patients. ", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "Through an effective blend of archival footage and the testimony of contemporary experts, ", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                " the movie lays out the lineage of the industry in postwar America, while rooting it in the present day. Eric Kohn - IndieWire", ""))


        videoList.add(Video((ID + 11).toString(),
                "NetFlix纪录片 尖端医疗的真相:你安全吗 The Bleeding Edge", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=28628871&page=1"))

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
