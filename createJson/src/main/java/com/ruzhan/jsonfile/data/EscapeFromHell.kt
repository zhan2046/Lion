package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object EscapeFromHell {

    private const val ID = 2403
    private const val PLAY_COUNT = "6"

    private const val TITLE = "极限重生"
    private const val TAG = "野外·冒险·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/escape-from-hell.jpg"

    private const val DESC = "揭示了平凡的人们在面对那些危险的险境如何求生，从强盗偷袭到雪崩，迷失在猛烈的沙尘暴中，现实中的熊群的偷袭。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/escape-from-hell01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "贝尔将为这些受困的人的做出那些举动给予评价，并重现当时情景，以免你已深处险境而不知所措提供良好的帮助，及时脱险。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "无论身处丛林，雪山、炽热的沙漠或陡峭的峡谷，贝尔将评估那些的幸存者在险境中所做的事。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "并重现他们在所应对险境中每步正确的求生做法，也会展示错误的做法导致的后果的情景。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "但往往这些错误的会让你丧失生命，但最后这些幸存者要为自己智慧而惊憾不已而好好庆祝几番。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "但我们要及时警惕这些险境，以免我们自己被送入真正的“地狱”。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、第一集", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396988&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、第二集", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396989&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、第三集", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396990&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、第四集", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396985&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、第五集", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396986&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、第六集", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=10536717&cid=17396987&page=6"))

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
