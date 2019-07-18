package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

/**
 * Created by ruzhan123 on 2018/7/3.
 */
object ManVsWild2 {

    private val ID = 4303
    private val PLAY_COUNT = "15"

    private val TITLE = "荒野求生 贝尔·格里尔斯"
    private val TAG = "纪录片·历史·冒险"

    private val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/man-vs-wild2.jpg"

    private val DESC = "由英国冒险家贝尔·吉罗斯主持，每集他会走到沙漠、沼泽、森林、峡谷等不适合人类生存的境地。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/man-vs-wild201.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "模拟在极为恶劣的环境下，为脱离险境，设法寻找回到文明社会的路径，在前进的道路上他沿绳滑落深谷、甚至徒手攀爬峭壁等。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他的冒险事迹包括攀登珠穆朗玛峰，骑乘水上摩托车环绕不列颠群岛，搭乘小船横越冰寒的北大西洋，及攀登希拉瑞爵士口中「无法征服」的喜马拉雅山。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/man-vs-wild202.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "且看贝尔从犹他州沙漠的流沙死里逃生，在哥斯达黎加驾船行驶于湍急的河流中，在阿尔卑斯山搭建雪屋，在夏威夷大胆穿越鲨鱼成群出没的水域。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "历尽千辛万苦逃离各种恶劣，甚至可能致命的环境。前提是：必须有强烈的危机意识！", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、荒野求生 一", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=48"))

        videoList.add(Video((ID + 12).toString(),
                "2、荒野求生 二", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=49"))

        videoList.add(Video((ID + 13).toString(),
                "3、荒野求生 三", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=50"))

        videoList.add(Video((ID + 14).toString(),
                "4、荒野求生 四", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=51"))

        videoList.add(Video((ID + 15).toString(),
                "5、荒野求生 五", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=52"))

        videoList.add(Video((ID + 16).toString(),
                "6、荒野求生 六", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=53"))

        videoList.add(Video((ID + 17).toString(),
                "7、荒野求生 七", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=54"))

        videoList.add(Video((ID + 18).toString(),
                "8、荒野求生 八", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=55"))

        videoList.add(Video((ID + 19).toString(),
                "9、荒野求生 九", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=56"))

        videoList.add(Video((ID + 20).toString(),
                "10、荒野求生 十", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=57"))

        videoList.add(Video((ID + 21).toString(),
                "11、荒野求生 十一", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=58"))

        videoList.add(Video((ID + 22).toString(),
                "12、荒野求生 十二", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=59"))

        videoList.add(Video((ID + 23).toString(),
                "13、荒野求生 十三", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=60"))

        videoList.add(Video((ID + 24).toString(),
                "14、荒野求生 十四", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=61"))

        videoList.add(Video((ID + 25).toString(),
                "15、荒野求生 十五", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=30021392&cid=52306692&page=62"))

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
