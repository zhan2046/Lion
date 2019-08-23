package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object CosmicDisclosure2 {

    private const val ID = 3303
    private const val PLAY_COUNT = "37"

    private const val TITLE = "揭露宇宙 24-100集"
    private const val TAG = "揭露宇宙·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure02.jpg"

    private const val DESC = "一部关于秘密太空计划（SSP）、宇宙历史、外星人讯息等有关内容的揭露节目。"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/cosmi-disclosure01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "科里·古德拥有在SSP秘密太空计划（Secret Space Programs） 的“特别行动顾问”职位上服役20多年的经历。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "他熟悉外星生物，并且与外星人联合工作、交流多年。关于他不可思议的接触经历，我们可以从节目内容与细节中获知更多首次揭露的信息。", ""))

        videoList.add(Video((ID + 11).toString(),
                "24集（征服太阳系）", IMAGE, PLAY_COUNT, 1, "第二十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196167&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "25集（超越太阳系）", IMAGE, PLAY_COUNT, 2, "第二十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196168&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "26集（秘密太空计划的科技）", IMAGE, PLAY_COUNT, 3, "第二十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196248&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "27集（观众提问part 1）", IMAGE, PLAY_COUNT, 4, "第二十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196325&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "28集（来自人工智能的威胁）", IMAGE, PLAY_COUNT, 5, "第二十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196467&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "29集（警惕人工智能）", IMAGE, PLAY_COUNT, 6, "第二十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196588&page=6"))

        videoList.add(Video((ID + 17).toString(),
                "30集（人工智能战争的新前线）", IMAGE, PLAY_COUNT, 7, "第三十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196709&page=7"))

        videoList.add(Video((ID + 18).toString(),
                "31集（观众提问part 2）", IMAGE, PLAY_COUNT, 8, "第三十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196797&page=8"))

        videoList.add(Video((ID + 19).toString(),
                "32集（地底世界）", IMAGE, PLAY_COUNT, 9, "第三十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38196909&page=9"))

        videoList.add(Video((ID + 20).toString(),
                "33集（古德的地心之旅）", IMAGE, PLAY_COUNT, 10, "第三十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197042&page=10"))

        videoList.add(Video((ID + 21).toString(),
                "34集（班图精神与蓝鸟人）", IMAGE, PLAY_COUNT, 11, "第三十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197152&page=11"))

        videoList.add(Video((ID + 22).toString(),
                "35集（地底揭秘）", IMAGE, PLAY_COUNT, 12, "第三十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197253&page=12"))

        videoList.add(Video((ID + 23).toString(),
                "36集（地底之旅）", IMAGE, PLAY_COUNT, 13, "第三十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197400&page=13"))

        videoList.add(Video((ID + 24).toString(),
                "37集（地底图书馆）", IMAGE, PLAY_COUNT, 14, "第三十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197513&page=14"))

        videoList.add(Video((ID + 25).toString(),
                "38集（地底之旅-进入记录大厅）", IMAGE, PLAY_COUNT, 15, "第三十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197588&page=15"))

        videoList.add(Video((ID + 26).toString(),
                "39集（地底之旅-向联盟汇报）", IMAGE, PLAY_COUNT, 16, "第三十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197692&page=16"))

        videoList.add(Video((ID + 27).toString(),
                "40集（班图精神与蓝鸟人信息part 2）", IMAGE, PLAY_COUNT, 17, "第四十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197783&page=17"))

        videoList.add(Video((ID + 28).toString(),
                "41集（超级地球）", IMAGE, PLAY_COUNT, 18, "第四十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197868&page=18"))

        videoList.add(Video((ID + 29).toString(),
                "42集（月球创造者之谜）", IMAGE, PLAY_COUNT, 19, "第四十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38197991&page=19"))

        videoList.add(Video((ID + 30).toString(),
                "43集（年龄回退与时间旅行）", IMAGE, PLAY_COUNT, 20, "第四十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198094&page=20"))

        videoList.add(Video((ID + 31).toString(),
                "44集（恶意混淆信息中心）", IMAGE, PLAY_COUNT, 21, "第四十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198194&page=21"))

        videoList.add(Video((ID + 32).toString(),
                "45集（上帝之音技术）", IMAGE, PLAY_COUNT, 22, "第四十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198306&page=22"))

        videoList.add(Video((ID + 33).toString(),
                "46集（黑暗舰队）", IMAGE, PLAY_COUNT, 23, "第四十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198405&page=23"))

        videoList.add(Video((ID + 34).toString(),
                "47集（观众提问part 3）", IMAGE, PLAY_COUNT, 24, "第四十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198474&page=24"))

        videoList.add(Video((ID + 35).toString(),
                "48集（地底最新报道）", IMAGE, PLAY_COUNT, 25, "第四十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198563&page=25"))

        videoList.add(Video((ID + 36).toString(),
                "49集（人格变形项目）", IMAGE, PLAY_COUNT, 26, "第四十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198650&page=26"))

        videoList.add(Video((ID + 37).toString(),
                "50集（地球联盟）", IMAGE, PLAY_COUNT, 27, "第五十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198743&page=27"))

        videoList.add(Video((ID + 38).toString(),
                "51集（观众提问part 4）", IMAGE, PLAY_COUNT, 28, "第五十一集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198850&page=28"))

        videoList.add(Video((ID + 39).toString(),
                "52集（天体时间线）", IMAGE, PLAY_COUNT, 29, "第五十二集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38198944&page=29"))

        videoList.add(Video((ID + 40).toString(),
                "53集（遥视与远程影响）", IMAGE, PLAY_COUNT, 30, "第五十三集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199007&page=30"))

        videoList.add(Video((ID + 41).toString(),
                "54集（古代艺术中的蓝鸟人和球体）", IMAGE, PLAY_COUNT, 31, "第五十四集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199103&page=31"))

        videoList.add(Video((ID + 42).toString(),
                "55集（扬升中的共生关系）", IMAGE, PLAY_COUNT, 32, "第五十五集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199200&page=32"))

        videoList.add(Video((ID + 43).toString(),
                "56集（灵性提升与科技的对抗）", IMAGE, PLAY_COUNT, 33, "第五十六集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199303&page=33"))

        videoList.add(Video((ID + 44).toString(),
                "57集（等离子生物与以太体）", IMAGE, PLAY_COUNT, 34, "第五十七集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199412&page=34"))

        videoList.add(Video((ID + 45).toString(),
                "58集（隐性威胁和公开披露）", IMAGE, PLAY_COUNT, 35, "第五十八集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199492&page=35"))

        videoList.add(Video((ID + 46).toString(),
                "59集（从金星到南极）", IMAGE, PLAY_COUNT, 36, "第五十九集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199671&page=36"))

        videoList.add(Video((ID + 47).toString(),
                "60集（周年特辑）", IMAGE, PLAY_COUNT, 37, "第六十集",
                "http://player.bilibili.com/player.html?aid=22979818&cid=38199699&page=37"))

        videoList.add(Video((ID + 48).toString(),
                "61集 秘密太空计划SSP证词", IMAGE, PLAY_COUNT, 38, "第六十一集",
                "http://player.bilibili.com/player.html?aid=26571284&cid=45640710&page=1"))

        videoList.add(Video((ID + 49).toString(),
                "62集汤普金斯生平介绍", IMAGE, PLAY_COUNT, 39, "第六十二集",
                "http://player.bilibili.com/player.html?aid=26571284&cid=45640713&page=2"))

        videoList.add(Video((ID + 50).toString(),
                "63集 SSP智库", IMAGE, PLAY_COUNT, 40, "第六十三集",
                "http://player.bilibili.com/player.html?aid=26571284&page=3"))

        videoList.add(Video((ID + 51).toString(),
                "64集《感应者与外星人》", IMAGE, PLAY_COUNT, 41, "第六十四集",
                "http://player.bilibili.com/player.html?aid=26571284&page=4"))

        videoList.add(Video((ID + 52).toString(),
                "65集《克里福德·斯通简介》", IMAGE, PLAY_COUNT, 42, "第六十五集",
                "http://player.bilibili.com/player.html?aid=26571284&page=5"))

        videoList.add(Video((ID + 53).toString(),
                "66集 斯通接触", IMAGE, PLAY_COUNT, 43, "第六十六集",
                "http://player.bilibili.com/player.html?aid=26571284&page=6"))

        videoList.add(Video((ID + 54).toString(),
                "67集 秘密面纱", IMAGE, PLAY_COUNT, 44, "第六十七集",
                "http://player.bilibili.com/player.html?aid=26571284&page=7"))

        videoList.add(Video((ID + 55).toString(),
                "68集 验证SSP", IMAGE, PLAY_COUNT, 45, "第六十八集",
                "http://player.bilibili.com/player.html?aid=26571284&page=8"))

        videoList.add(Video((ID + 56).toString(),
                "69集 联盟反击", IMAGE, PLAY_COUNT, 46, "第六十九集",
                "http://player.bilibili.com/player.html?aid=26571284&page=9"))

        videoList.add(Video((ID + 57).toString(),
                "70集 冈萨雷斯的回归", IMAGE, PLAY_COUNT, 47, "第七十集",
                "http://player.bilibili.com/player.html?aid=26571284&page=10"))

        videoList.add(Video((ID + 58).toString(),
                "71集 相遇古哨兵", IMAGE, PLAY_COUNT, 48, "第七十一集",
                "http://player.bilibili.com/player.html?aid=26571284&page=11"))

        videoList.add(Video((ID + 58).toString(),
                "72集 验证20年逆龄项目", IMAGE, PLAY_COUNT, 49, "第七十二集",
                "http://player.bilibili.com/player.html?aid=26571284&page=12"))

        videoList.add(Video((ID + 60).toString(),
                "73集 球体的到来", IMAGE, PLAY_COUNT, 50, "第七十三集",
                "http://player.bilibili.com/player.html?aid=26571284&page=13"))

        videoList.add(Video((ID + 61).toString(),
                "74集 外星科技的利用", IMAGE, PLAY_COUNT, 51, "第七十四集",
                "http://player.bilibili.com/player.html?aid=26571284&page=14"))

        videoList.add(Video((ID + 62).toString(),
                "75集 外星人指南", IMAGE, PLAY_COUNT, 52, "第七十五集",
                "http://player.bilibili.com/player.html?aid=26571284&page=15"))

        videoList.add(Video((ID + 63).toString(),
                "76集 太阳典狱长计划-创始人", IMAGE, PLAY_COUNT, 53, "第七十六集",
                "http://player.bilibili.com/player.html?aid=26571284&page=16"))

        videoList.add(Video((ID + 64).toString(),
                "77集 一的法则-与秘密太空计划", IMAGE, PLAY_COUNT, 54, "第七十七集",
                "http://player.bilibili.com/player.html?aid=26571284&page=17"))

        videoList.add(Video((ID + 65).toString(),
                "78集 指导人类扬升", IMAGE, PLAY_COUNT, 55, "第七十八集",
                "http://player.bilibili.com/player.html?aid=26571284&page=18"))

        videoList.add(Video((ID + 66).toString(),
                "79集 地心放逐者", IMAGE, PLAY_COUNT, 56, "第七十九集",
                "http://player.bilibili.com/player.html?aid=26571284&page=19"))

        videoList.add(Video((ID + 67).toString(),
                "80集 不安的遭遇", IMAGE, PLAY_COUNT, 57, "第八十集",
                "http://player.bilibili.com/player.html?aid=26571284&page=20"))

        videoList.add(Video((ID + 68).toString(),
                "81集 技术拯救", IMAGE, PLAY_COUNT, 58, "第八十一集",
                "http://player.bilibili.com/player.html?aid=26571284&page=21"))

        videoList.add(Video((ID + 69).toString(),
                "82集 揭露后的生活", IMAGE, PLAY_COUNT, 59, "第八十二集",
                "http://player.bilibili.com/player.html?aid=26571284&page=22"))

        videoList.add(Video((ID + 70).toString(),
                "83集 采访内幕人士", IMAGE, PLAY_COUNT, 60, "第八十三集",
                "http://player.bilibili.com/player.html?aid=26571284&page=23"))

        videoList.add(Video((ID + 71).toString(),
                "84集 揭示更大计划", IMAGE, PLAY_COUNT, 61, "第八十四集",
                "http://player.bilibili.com/player.html?aid=26571284&page=24"))

        videoList.add(Video((ID + 72).toString(),
                "85集 观众提问五", IMAGE, PLAY_COUNT, 62, "第八十五集",
                "http://player.bilibili.com/player.html?aid=26571284&page=25"))

        videoList.add(Video((ID + 73).toString(),
                "86集 掀开军工帷幕", IMAGE, PLAY_COUNT, 63, "第八十六集",
                "http://player.bilibili.com/player.html?aid=26571284&page=26"))

        videoList.add(Video((ID + 74).toString(),
                "87集 揭示隐藏技术", IMAGE, PLAY_COUNT, 64, "第八十七集",
                "http://player.bilibili.com/player.html?aid=26571284&page=27"))

        videoList.add(Video((ID + 75).toString(),
                "88集 一的法则与负面势力", IMAGE, PLAY_COUNT, 65, "第八十八集",
                "http://player.bilibili.com/player.html?aid=26571284&page=28"))

        videoList.add(Video((ID + 76).toString(),
                "89集 一的法则与通灵因果", IMAGE, PLAY_COUNT, 66, "第八十九集",
                "http://player.bilibili.com/player.html?aid=26571284&page=29"))

        videoList.add(Video((ID + 77).toString(),
                "90集 巨大的太阳闪焰", IMAGE, PLAY_COUNT, 67, "第九十集",
                "http://player.bilibili.com/player.html?aid=26571284&page=30"))

        videoList.add(Video((ID + 78).toString(),
                "91集 太阳闪焰的转变力", IMAGE, PLAY_COUNT, 68, "第九十一集",
                "http://player.bilibili.com/player.html?aid=26571284&page=31"))

        videoList.add(Video((ID + 79).toString(),
                "92集 深度揭露 威廉.汤普金斯", IMAGE, PLAY_COUNT, 69, "第九十二集",
                "http://player.bilibili.com/player.html?aid=26571284&page=32"))

        videoList.add(Video((ID + 80).toString(),
                "93集 南极：揭露进程", IMAGE, PLAY_COUNT, 70, "第九十三集",
                "http://player.bilibili.com/player.html?aid=26571284&page=33"))

        videoList.add(Video((ID + 81).toString(),
                "94集 验证证据", IMAGE, PLAY_COUNT, 71, "第九十四集",
                "http://player.bilibili.com/player.html?aid=26571284&page=34"))

        videoList.add(Video((ID + 82).toString(),
                "95集 揭露秘密地下战争", IMAGE, PLAY_COUNT, 72, "第九十五集",
                "http://player.bilibili.com/player.html?aid=26571284&page=35"))

        videoList.add(Video((ID + 83).toString(),
                "96集 追溯秘密太空根源", IMAGE, PLAY_COUNT, 73, "第九十六集",
                "http://player.bilibili.com/player.html?aid=26571284&page=36"))

        videoList.add(Video((ID + 84).toString(),
                "97集 观众提问六", IMAGE, PLAY_COUNT, 74, "第九十七集",
                "http://player.bilibili.com/player.html?aid=26571284&page=37"))

        videoList.add(Video((ID + 85).toString(),
                "98集 推动揭露极限", IMAGE, PLAY_COUNT, 75, "第九十八集",
                "http://player.bilibili.com/player.html?aid=26571284&page=38"))

        videoList.add(Video((ID + 86).toString(),
                "99集 阿波罗之秘", IMAGE, PLAY_COUNT, 76, "第九十九集",
                "http://player.bilibili.com/player.html?aid=26571284&page=39"))

        videoList.add(Video((ID + 87).toString(),
                "100集 观众提问七", IMAGE, PLAY_COUNT, 77, "第一百集",
                "http://player.bilibili.com/player.html?aid=26571284&page=40"))

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
