package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object NakedCastaway {

    private const val ID = 1803
    private const val PLAY_COUNT = "4"

    private const val TITLE = "只身在荒岛"
    private const val TAG = "野外·野求·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/naked-castaway.jpg"

    private const val DESC = "Naked Castaway 前英国陆军上尉埃德·斯塔福德即将展开电视史上最夸张的终极求生挑战。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/naked-castaway01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "他将从飞机上空降落地，全身赤裸地来到斐济的无人岛欧罗路亚岛，60天内光靠大脑与双手求生。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他身上没有衣物、食物、饮用水、刀子或工具，只有一台摄影机用来全程记录他的求生过程、一个急救箱，以及一支只有在遇上紧急医疗状况才能使用的对讲机。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "岛上没有任何求生工具、配粮、衣物或拍摄团队。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "在荒岛上生存了60天後，埃德平安返家，诉说这段奇妙的荒岛探险之旅：过程中的高低起伏，以及他对求生和自己多了哪些认识。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他将分享荒岛生活经验的前後感想，以及这场实验对他产生了哪些持续至今的影响。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、寻找饮水", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=10409731&cid=17191743&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、遮风挡雨", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=10409731&cid=17191744&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、投身鲨鱼海", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=10409731&cid=17191745&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、经验分享", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=10409731&cid=17191746&page=4"))

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
