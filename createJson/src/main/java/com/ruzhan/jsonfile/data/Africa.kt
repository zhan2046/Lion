package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

/**
 * Created by ruzhan123 on 2018/7/3.
 */
object Africa {

    private const val ID = 4803
    private const val PLAY_COUNT = "6"

    private const val TITLE = "BBC：非洲"
    private const val TAG = "自然·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/africa.jpg"

    private const val DESC = "《非洲》由《Life》原班人马打造，是一部大型原生态纪录片。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/africa01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "镜头将跟随主持人David Attenborough一起穿越神奇的非洲大陆，探索那些从未被发现、被记录的生物物种和壮观的非洲奇迹。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/africa02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "从高耸的阿特拉斯山到好望角；从茂密的刚果丛林到无边无际的大西洋：体验未被发现过的雨林、从未拍摄过的山区和白雪覆盖的沙漠", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "伴随着野外景观与野外生活的变化多样，这部纪录片，再现了这片壮丽大陆的美丽和威力。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、BBC：非洲", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=22763761&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、BBC：非洲", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=22763761&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、BBC：非洲", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=22763761&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、BBC：非洲", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=22763761&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、BBC：非洲", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=22763761&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、BBC：非洲", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=22763761&page=6"))


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
