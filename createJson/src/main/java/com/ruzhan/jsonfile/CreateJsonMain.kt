package com.ruzhan.jsonfile

import com.google.gson.Gson
import com.ruzhan.jsonfile.helper.MovieHelper
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail

object CreateJsonMain {

    const val FILE_TYPE = ".json"
    private const val MOVIE_LIST = "E:\\project\\Lion\\json\\api\\movie"
    private const val MOVIE_DETAIL = "E:\\project\\Lion\\json\\api\\movie\\detail"

    const val CODE_SUCCESS = 200

    private val mainGSon = Gson()

    @JvmStatic
    fun main(args: Array<String>) {
        println("init json file...")
        println("=================================")

        println("1, create movie list json files")
        val movieList = MovieHelper.movieList
        val movieMap = MovieHelper.getMovieMap(movieList)
        println("movieMap size:" + movieMap.size)
        MovieHelper.movieListToJsonFile(movieMap, MOVIE_LIST, mainGSon)
        println("1, create movie list json files finish ... !!!")
        println("=================================")

        println("2, create movie detail json files")
        val detailList = MovieHelper.movieDetailList
        MovieHelper.movieDetailListToJsonFile(detailList, MOVIE_DETAIL, mainGSon)
        println("2, create movie detail json files finish ... !!!")
        println("=================================")

        println("json file create finish ... !!!")
    }
}
