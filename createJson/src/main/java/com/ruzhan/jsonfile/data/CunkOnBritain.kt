package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

/**
 * Created by ruzhan123 on 2018/7/3.
 */
object CunkOnBritain {

    private val ID = 5203
    private val PLAY_COUNT = "7"

    private val TITLE = "扯蛋英国史 Cunk On Britain"
    private val TAG = "历史·纪录片"

    private val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cunk-on-britain.jpg"

    private val DESC = "BBC伪纪录片喜剧，《黑镜》编剧Charlie Brooker的新作。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cunk-on-britain01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "节目跟随无知的主持人Philomena Cunk追溯英国历史，看她如何扯蛋和胡诌历史。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cunk-on-britain02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "Philomena Cunk是个虚拟的纪录片主持人，由Diane Morgan扮演，最初来自Charlie Brooker编剧和主持的《Charlie Brooker’s Weekly Wipe》节目。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "2016年以她为主角衍生出了两个特别集《扯蛋莎翁史》和《扯蛋圣诞史》。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、扯蛋莎翁史", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=23449067&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、扯蛋圣诞史", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=23449067&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、扯蛋英国史 S01E01", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=23449067&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、扯蛋英国史 S01E02", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=23449067&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、扯蛋英国史 S01E03", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=23449067&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、扯蛋英国史 S01E04", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=23449067&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、扯蛋英国史 S01E05(季终)", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=23449067&page=7"))


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
