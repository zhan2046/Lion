package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheMonkeyKing {

    private const val ID = 4203
    private const val PLAY_COUNT = "1"

    private const val TITLE = "大闹天宫"
    private const val TAG = "动画·奇幻·家庭·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-monkey-king.jpg"

    private const val DESC = "《大闹天宫》是上海美术电影制片厂于1961年—1964年制作的一部彩色动画长片。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-monkey-king01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "由法国Les Films de ma Vie (VHS)公司发行，万籁鸣、唐澄联合执导。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/the-monkey-king02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "该片以神话形式，通过孙悟空闹龙宫、反天庭的故事，比较集中而突出地表现了主角孙悟空的传奇经历。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "2016年8月，上海美术电影制片厂出品《大闹天宫》同名有声图书，由李世宏为孙悟空配音。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "此版本时长114分钟，由外国影迷 satanika 发起并主持修复完成。除去片尾详细字幕，正片长度为108分钟。据说这个“非法”版本可能是迄今为止最完整的版本。", ""))


        videoList.add(Video((ID + 11).toString(),
                "大闹天宫影迷修复版 THE MONKEY KING UPROAR IN HEAVEN 1961", IMAGE, PLAY_COUNT, 1, "电影",
                "http://player.bilibili.com/player.html?aid=25319561&page=1"))

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
