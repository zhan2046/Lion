package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object TheLionSleepsNoMore {

    private const val ID = 303
    private const val PLAY_COUNT = "6"

    private const val TITLE = "大卫·艾克《雄狮醒来》"
    private const val TAG = "公开课·雄狮醒来"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/christ-lion.jpg"

    private const val DESC = "David Vaughan Icke，英国作家、公共演说家、前足球员与体育职业解说员。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他提出一种关于全球政治的阴谋论，并将它详细地写了出来。艾克曾是一名BBC电视台体育主持人和绿党的发言人。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/young-david-icke.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "1990年，一位通灵者告诉他，他是带着某种使命被派到地球上的“治愈者”，而且灵异世界将向他传达讯息。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "然而他继续发展他的想法，并且在七年内已经出版四本书。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke-img01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "《机器的反抗》（The Robots' Rebellion，1994）、《真相使你自由》（And the Truth Shall Set You Free，1995）、《最大的秘密》（The Biggest Secret，1999）与《矩阵的孩子》（Children of the Matrix，2001）。", ""))


        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke-img02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "在作品中，他把“新世纪理论”和现代社会极权化现象结合，提出一种世界性的观点。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke-img03.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "他的理论核心是一个由“爬虫类人”（包括乔治·W·布什、伊丽莎白二世、克里斯·克里斯托佛森及）组成的称为“巴比伦兄弟会”的秘密团体控制着人类，而且很多显赫的名流都是爬虫类人。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他还宣称月球是一个人工建筑——“大概是个中空的行星”，在那里爬虫博克斯卡·威利类人给人类创造了一个“人工的自我意识和世界”，人类却误以为是真实。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke-img04.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "麦克·巴昆（Michael Barkun）把艾克的观点描述为“新世纪阴谋主义”，认为他是最有影响力的阴谋论流派。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "理查德·卡恩和泰森·刘易斯认为，爬虫类人的假设可能仅仅是斯威夫特式的讽刺，是一种让普通民众质疑他们身边所见事物的叙事方式。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke-img05.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "灵魂是用他的思想来染色。思考那些符合你的原则的事情，承担起生活赋予你的责任。你的品格取决于你的选择。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "日复一日，你选择什么、你思考什么、你做过什么你就会成为什么样的人。你的正直即是你的命运--那正是指引你的光芒。-- 大卫·艾克”", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "近年来，艾克更是频繁的到世界各地演讲。2011年，艾克开启了他的全球巡回演讲之旅。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "足迹遍及欧洲、美国、澳洲、新西兰、日本、以及南非。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/david-icke.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "目前国内出现了几部大卫艾克的带有中文字幕的演讲，包括《地球史上最震撼的访谈》、《超越世界》、《雄狮醒来》等。", ""))

        videoList.add(Video((ID + 11).toString(),
                "1、超越世界1-上", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065849&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、超越世界1-下", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065850&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、超越世界2-上", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065851&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、超越世界2-下", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065852&page=4"))

        videoList.add(Video((ID + 14).toString(),
                "5、超越世界3-上", IMAGE, PLAY_COUNT, 4, "第五集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065853&page=5"))

        videoList.add(Video((ID + 14).toString(),
                "6、超越世界3-下(完)", IMAGE, PLAY_COUNT, 4, "第六集",
                "http://player.bilibili.com/player.html?aid=4966026&cid=8065854&page=6"))

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
