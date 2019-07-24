package com.ruzhan.jsonfile.data

import com.ruzhan.jsonfile.model.Introduce
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.model.Video

import java.util.ArrayList

object OldGuang {

    private const val ID = 5303
    private const val PLAY_COUNT = "6"

    private const val TITLE = "老广的味道 第一季"
    private const val TAG = "人文·纪录片"

    private const val IMAGE = "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/old-guang.jpg"

    private const val DESC = "《老广的味道》以独特视角深入广东美食腹地追根溯源，挖掘原汁原味的美食美景，体现特色全粤菜谱"

    val movie = Movie()
    val movieDetail = MovieDetail()

    private val introduceList = ArrayList<Introduce>()
    private val videoList = ArrayList<Video>()

    init {
        introduceList.add(Introduce(Introduce.TEXT,
                DESC, ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/old-guang01.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "上山下海，探索南粤大地深藏的最高食鲜；味蕾冒险，展现岭南就地取材的生存智慧。", ""))

        introduceList.add(Introduce(Introduce.IMAGE, "",
                "https://raw.githubusercontent.com/ruzhan123/Lion/master/json/api/image/old-guang02.jpg"))

        introduceList.add(Introduce(Introduce.TEXT,
                "依天而食，回归老广时令节气的饮食法则；原声原味，搜寻天间特色环境的自然之味。", ""))

        introduceList.add(Introduce(Introduce.TEXT,
                "大道至简，还原广东乡野厨艺的朴素之心；以食养生，揭示南方天地元气的滋养之谜。", ""))


        videoList.add(Video((ID + 11).toString(),
                "1、老广的味道", IMAGE, PLAY_COUNT, 1, "第一集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=1"))

        videoList.add(Video((ID + 12).toString(),
                "2、老广的味道", IMAGE, PLAY_COUNT, 2, "第二集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=2"))

        videoList.add(Video((ID + 13).toString(),
                "3、老广的味道", IMAGE, PLAY_COUNT, 3, "第三集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=3"))

        videoList.add(Video((ID + 14).toString(),
                "4、老广的味道", IMAGE, PLAY_COUNT, 4, "第四集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=4"))

        videoList.add(Video((ID + 15).toString(),
                "5、老广的味道", IMAGE, PLAY_COUNT, 5, "第五集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=5"))

        videoList.add(Video((ID + 16).toString(),
                "6、老广的味道", IMAGE, PLAY_COUNT, 6, "第六集",
                "http://player.bilibili.com/player.html?aid=26405036&cid=45373169&page=6"))


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
