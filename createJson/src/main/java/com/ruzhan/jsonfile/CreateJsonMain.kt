package com.ruzhan.jsonfile

import com.google.gson.Gson
import com.ruzhan.jsonfile.helper.MovieHelper
import java.io.File

object CreateJsonMain {

    private const val USER_DIR = "user.dir"
    private const val JSON = "json"
    private const val API = "api"
    private const val MOVIE = "movie"
    private const val DETAIL = "detail"
    const val FILE_TYPE = ".json"

    private val mainGSon = Gson()
    private var movieListFile = File("")
    private var movieDetailFile = File("")

    @JvmStatic
    fun main(args: Array<String>) {
        initCreateJsonFile()
        createMovieListToJsonFile()
        createMovieDetailListToJsonFile()
        println("=======")
        println("==============")
        println("======= CreateJsonMain finish !!! =======")
    }

    private fun initCreateJsonFile() {
        println("initCreateJsonFile call...")
        val userDirFile = File(System.getProperty(USER_DIR))
        println("userDirFile:${userDirFile.absolutePath}")

        val createJsonFile = File(File(userDirFile, JSON), API)
        println("createJsonFile:${createJsonFile.absolutePath}")

        movieListFile = File(createJsonFile, MOVIE)
        println("movieListFile:${movieListFile.absolutePath}")

        movieDetailFile = File(movieListFile, DETAIL)
        println("movieDetailFile:${movieDetailFile.absolutePath}")
        println("======= initCreateJsonFile finish !!! =========")
    }

    private fun createMovieListToJsonFile() {
        println("createMovieListToJsonFile call...")
        val movieList = MovieHelper.movieList
        val movieMap = MovieHelper.getMovieMap(movieList)
        println("createMovieListToJsonFile movieMap size:" + movieMap.size)
        MovieHelper.movieListToJsonFile(movieMap, movieListFile.absolutePath, mainGSon)
        println("======== createMovieListToJsonFile finish !!! ==========")
    }

    private fun createMovieDetailListToJsonFile() {
        println("createMovieDetailListToJsonFile call...")
        val detailList = MovieHelper.movieDetailList
        MovieHelper.movieDetailListToJsonFile(detailList, movieDetailFile.absolutePath, mainGSon)
        println("======= createMovieDetailListToJsonFile finish !!! ==========")
    }
}
