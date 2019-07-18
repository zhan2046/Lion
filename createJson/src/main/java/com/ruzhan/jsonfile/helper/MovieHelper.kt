package com.ruzhan.jsonfile.helper

import com.google.gson.Gson
import com.ruzhan.jsonfile.CreateJsonMain
import com.ruzhan.jsonfile.data.*
import com.ruzhan.jsonfile.model.HttpResult
import com.ruzhan.jsonfile.model.Movie
import com.ruzhan.jsonfile.model.MovieDetail
import com.ruzhan.jsonfile.utils.JsonFileIOUtils
import java.util.HashMap
import kotlin.collections.ArrayList

object MovieHelper {

    private const val PAGE_COUNT = 60

    val movieList: List<Movie>
        get() {
            val list = ArrayList<Movie>()
            list.add(TheLionSleepsNoMore.movie)
            list.add(NikolaTesla.movie)
            list.add(Thrive.movie)
            list.add(TED2018.movie)
            list.add(TED2017.movie)
            list.add(TED2016.movie)
            list.add(CosmicDisclosure.movie)
            list.add(CosmicDisclosure2.movie)
            list.add(CosmicDisclosure3.movie)
            list.add(Interstella.movie)
            list.add(DaftPunk.movie)
            list.add(Human.movie)
            list.add(TheSecret.movie)
            list.add(SouthPark.movie)
            list.add(AliensMoon.movie)
            list.add(AncientAliens.movie)
            list.add(MadeUsSpend.movie)
            list.add(RichAndUs.movie)
            list.add(WildChina.movie)
            list.add(ScamCity.movie)
            list.add(ScamCity2.movie)
            list.add(WorldOfBlood.movie)
            list.add(HiddenLife.movie)
            list.add(TheBleedingEdge.movie)
            list.add(Monsanto.movie)
            list.add(StoryOfCapital.movie)
            list.add(ValeriyBabich.movie)
            list.add(Weapon.movie)
            list.add(RealWar.movie)
            list.add(VietnamWar.movie)
            list.add(CunkOnBritain.movie)
            list.add(CredoMutwa.movie)
            list.add(TheOrionConspiracy.movie)
            list.add(KeJi.movie)
            list.add(TheLieWeLive.movie)
            list.add(PunPun.movie)
            list.add(AYearinSpace.movie)
            list.add(TheFarthest.movie)
            list.add(LifeIsFruity.movie)
            list.add(OldGuang.movie)
            list.add(ManVsWild.movie)
            list.add(ManVsWild2.movie)
            list.add(EscapeFromHell.movie)
            list.add(RunningWild.movie)
            list.add(NakedCastaway.movie)
            list.add(JamesCameron.movie)
            list.add(Marvel.movie)
            list.add(WeGotNext.movie)
            list.add(DevinWilliams.movie)
            list.add(TheStoryOfGod.movie)
            list.add(ThroughTheWormhole.movie)
            list.add(OnTheRoad.movie)
            list.add(ThreeCountries.movie)
            list.add(TheCove.movie)
            list.add(FrozenPlanet.movie)
            list.add(TheHunt.movie)
            list.add(Africa.movie)
            list.add(TheMonkeyKing.movie)
            return list
        }

    val movieDetailList: List<MovieDetail>
        get() {
            val list = ArrayList<MovieDetail>()
            list.add(TheLionSleepsNoMore.movieDetail)
            list.add(NikolaTesla.movieDetail)
            list.add(Thrive.movieDetail)
            list.add(TED2018.movieDetail)
            list.add(TED2017.movieDetail)
            list.add(TED2016.movieDetail)
            list.add(CosmicDisclosure.movieDetail)
            list.add(CosmicDisclosure2.movieDetail)
            list.add(CosmicDisclosure3.movieDetail)
            list.add(Interstella.movieDetail)
            list.add(DaftPunk.movieDetail)
            list.add(Human.movieDetail)
            list.add(TheSecret.movieDetail)
            list.add(SouthPark.movieDetail)
            list.add(AliensMoon.movieDetail)
            list.add(AncientAliens.movieDetail)
            list.add(MadeUsSpend.movieDetail)
            list.add(RichAndUs.movieDetail)
            list.add(WildChina.movieDetail)
            list.add(ScamCity.movieDetail)
            list.add(ScamCity2.movieDetail)
            list.add(WorldOfBlood.movieDetail)
            list.add(HiddenLife.movieDetail)
            list.add(TheBleedingEdge.movieDetail)
            list.add(Monsanto.movieDetail)
            list.add(StoryOfCapital.movieDetail)
            list.add(ValeriyBabich.movieDetail)
            list.add(Weapon.movieDetail)
            list.add(RealWar.movieDetail)
            list.add(VietnamWar.movieDetail)
            list.add(CunkOnBritain.movieDetail)
            list.add(CredoMutwa.movieDetail)
            list.add(TheOrionConspiracy.movieDetail)
            list.add(KeJi.movieDetail)
            list.add(TheLieWeLive.movieDetail)
            list.add(PunPun.movieDetail)
            list.add(AYearinSpace.movieDetail)
            list.add(TheFarthest.movieDetail)
            list.add(LifeIsFruity.movieDetail)
            list.add(OldGuang.movieDetail)
            list.add(ManVsWild.movieDetail)
            list.add(ManVsWild2.movieDetail)
            list.add(EscapeFromHell.movieDetail)
            list.add(RunningWild.movieDetail)
            list.add(NakedCastaway.movieDetail)
            list.add(JamesCameron.movieDetail)
            list.add(Marvel.movieDetail)
            list.add(WeGotNext.movieDetail)
            list.add(DevinWilliams.movieDetail)
            list.add(TheStoryOfGod.movieDetail)
            list.add(ThroughTheWormhole.movieDetail)
            list.add(OnTheRoad.movieDetail)
            list.add(ThreeCountries.movieDetail)
            list.add(TheCove.movieDetail)
            list.add(FrozenPlanet.movieDetail)
            list.add(TheHunt.movieDetail)
            list.add(Africa.movieDetail)
            list.add(TheMonkeyKing.movieDetail)
            return list
        }

    fun movieDetailListToJsonFile(list: List<MovieDetail>,
                                  rootPath: String, gson: Gson) {
        for (movieDetail in list) {
            val name = movieDetail.movieId + CreateJsonMain.FILE_TYPE
            val filePath = rootPath + "\\" + name
            val httpResult = HttpResult(CreateJsonMain.CODE_SUCCESS,
                    "", movieDetail)
            val fileJson = gson.toJson(httpResult)
            val isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson)
            println("isKeyPageSuccess:$isKeyPageSuccess, movieDetailListToJsonFile write !!!")
        }
    }

    fun movieListToJsonFile(map: Map<String, List<Movie>>, rootPath: String, gson: Gson) {
        val entrySet = map.entries
        val iterator = entrySet.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            val keyPage = entry.key
            val valueMovieList = entry.value
            val filePath = rootPath + "\\" + keyPage + CreateJsonMain.FILE_TYPE
            val httpResult = HttpResult(CreateJsonMain.CODE_SUCCESS,
                    "", valueMovieList)
            val fileJson = gson.toJson(httpResult)
            val isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson)
            println("isKeyPageSuccess:$isKeyPageSuccess, keyPage:$keyPage")
        }
    }

    fun getMovieMap(list: List<Movie>): Map<String, List<Movie>> {
        val map = HashMap<String, List<Movie>>()
        var page = 1
        var count = 0
        for (i in list.indices) {
            val movies = map[page.toString()]
            val valueList = ArrayList<Movie>()
            if (movies != null && movies.isNotEmpty()) {
                valueList.addAll(movies)
            }
            val movie = list[i]
            valueList.add(movie)
            map[page.toString()] = valueList
            count++

            if (count >= PAGE_COUNT) {
                count = 0
                page++
            }
        }
        return map
    }
}
