package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object ValeriyBabich {

    private const val ID = 2903
    private const val PLAY_COUNT = "18"

    private const val TITLE = "伟大的卫国战争"
    private const val TAG = "战争·俄罗斯·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/valeriy-babich.jpg"

    private const val DESC = "俄罗斯第一频道为纪念卫国战争胜利65周年，在2010年拍摄的纪录片。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/valeriy-babich02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "纪录片采用了3D动画技术，并通过大量珍贵的史料、惨烈的战争场面、冷峻深沉的解说和雄浑悲壮的配乐赋予了这部纪录片史诗般的风格。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "以此展现战争期间众多令人震惊震撼、富有传奇色彩的历史事件。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、巴巴罗萨行动", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037708&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、基辅1941", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037701&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、塞瓦斯托波尔保卫战", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037705&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、莫斯科保卫战", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037712&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、列宁格勒之围", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037709&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、勒热夫-瑟乔夫卡战役", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037713&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "7、兵临城下", IMAGE, PLAY_COUNT, 7, "第七集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037702&page=7"))

        videoList.add(Video((ID + 18).toString(),
                "8、高加索战役", IMAGE, PLAY_COUNT, 8, "第八集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037703&page=8"))

        videoList.add(Video((ID + 19).toString(),
                "9、激战库尔斯克", IMAGE, PLAY_COUNT, 9, "第九集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037697&page=9"))

        videoList.add(Video((ID + 20).toString(),
                "10、巴格拉基昂行动", IMAGE, PLAY_COUNT, 10, "第十集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037706&page=10"))

        videoList.add(Video((ID + 21).toString(),
                "11、解放乌克兰", IMAGE, PLAY_COUNT, 11, "第十一集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037707&page=11"))

        videoList.add(Video((ID + 22).toString(),
                "12、空中大战", IMAGE, PLAY_COUNT, 12, "第十二集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037698&page=12"))

        videoList.add(Video((ID + 23).toString(),
                "13、大海战", IMAGE, PLAY_COUNT, 13, "第十三集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037699&page=13"))

        videoList.add(Video((ID + 24).toString(),
                "14、游击战", IMAGE, PLAY_COUNT, 14, "第十四集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037704&page=14"))

        videoList.add(Video((ID + 25).toString(),
                "15、谍报战", IMAGE, PLAY_COUNT, 15, "第十五集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037714&page=15"))

        videoList.add(Video((ID + 26).toString(),
                "16、大反攻", IMAGE, PLAY_COUNT, 16, "第十六集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037710&page=16"))

        videoList.add(Video((ID + 27).toString(),
                "17、柏林战役", IMAGE, PLAY_COUNT, 17, "第十七集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037700&page=17"))

        videoList.add(Video((ID + 28).toString(),
                "18、对日战争", IMAGE, PLAY_COUNT, 18, "第十八集",
                "http://player.bilibili.com/player.html?aid=10894939&cid=18037711&page=18"))


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
