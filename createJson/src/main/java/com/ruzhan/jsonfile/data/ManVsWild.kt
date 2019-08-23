package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video
import java.util.*

object ManVsWild {

    private const val ID = 2003
    private const val PLAY_COUNT = "15"

    private const val TITLE = "荒野求生"
    private const val TAG = "野外冒险·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/man-vs-wild.jpg"

    private const val DESC = "由英国冒险家贝尔·吉罗斯主持，每集他会走到沙漠、沼泽、森林、峡谷等不适合人类生存的境地。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/man-vs-wild01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "模拟在极为恶劣的环境下，为脱离险境，设法寻找回到文明社会的路径，在前进的道路上他沿绳滑落深谷、甚至徒手攀爬峭壁等。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他的冒险事迹包括攀登珠穆朗玛峰，骑乘水上摩托车环绕不列颠群岛，搭乘小船横越冰寒的北大西洋，及攀登希拉瑞爵士口中「无法征服」的喜马拉雅山。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "且看贝尔从犹他州沙漠的流沙死里逃生，在哥斯达黎加驾船行驶于湍急的河流中，在阿尔卑斯山搭建雪屋，在夏威夷大胆穿越鲨鱼成群出没的水域。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "历尽千辛万苦逃离各种恶劣，甚至可能致命的环境。前提是：必须有强烈的危机意识！", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、洛基山脉", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797838&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、莫阿布沙漠", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797859&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、哥斯达黎加雨林", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797845&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、阿拉斯加山脉", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797866&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、基拉韦厄火山", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797835&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、内华达山脉", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797827&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、非洲肯尼亚草原", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797861&page=7"))

        videoList.add(Video((ID + 18).toString(),
                "8、阿尔卑斯山脉", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797830&page=8"))

        videoList.add(Video((ID + 19).toString(),
                "9、无人荒岛", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797843&page=9"))

        videoList.add(Video((ID + 20).toString(),
                "10、佛罗里达州", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797856&page=10"))

        videoList.add(Video((ID + 21).toString(),
                "11、冰岛", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797840&page=11"))

        videoList.add(Video((ID + 22).toString(),
                "12、铜谷", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797853&page=12"))

        videoList.add(Video((ID + 23).toString(),
                "13、金伯利", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797850&page=13"))

        videoList.add(Video((ID + 24).toString(),
                "14、亚马逊雨林", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797847&page=14"))

        videoList.add(Video((ID + 25).toString(),
                "15、苏格兰", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=13956273&cid=22797832&page=15"))

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
