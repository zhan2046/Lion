package com.ruzhan.jsonfile.helper;

import com.google.gson.Gson;
import com.ruzhan.jsonfile.CreateJsonMain;
import com.ruzhan.jsonfile.data.AYearinSpace;
import com.ruzhan.jsonfile.data.Africa;
import com.ruzhan.jsonfile.data.AliensMoon;
import com.ruzhan.jsonfile.data.AncientAliens;
import com.ruzhan.jsonfile.data.CosmicDisclosure;
import com.ruzhan.jsonfile.data.CosmicDisclosure2;
import com.ruzhan.jsonfile.data.CredoMutwa;
import com.ruzhan.jsonfile.data.CunkOnBritain;
import com.ruzhan.jsonfile.data.DaftPunk;
import com.ruzhan.jsonfile.data.DevinWilliams;
import com.ruzhan.jsonfile.data.EscapeFromHell;
import com.ruzhan.jsonfile.data.FrozenPlanet;
import com.ruzhan.jsonfile.data.HiddenLife;
import com.ruzhan.jsonfile.data.Human;
import com.ruzhan.jsonfile.data.Interstella;
import com.ruzhan.jsonfile.data.JamesCameron;
import com.ruzhan.jsonfile.data.KeJi;
import com.ruzhan.jsonfile.data.LifeIsFruity;
import com.ruzhan.jsonfile.data.MadeUsSpend;
import com.ruzhan.jsonfile.data.ManVsWild;
import com.ruzhan.jsonfile.data.ManVsWild2;
import com.ruzhan.jsonfile.data.Marvel;
import com.ruzhan.jsonfile.data.Monsanto;
import com.ruzhan.jsonfile.data.NakedCastaway;
import com.ruzhan.jsonfile.data.NikolaTesla;
import com.ruzhan.jsonfile.data.OldGuang;
import com.ruzhan.jsonfile.data.OnTheRoad;
import com.ruzhan.jsonfile.data.PunPun;
import com.ruzhan.jsonfile.data.RealWar;
import com.ruzhan.jsonfile.data.RichAndUs;
import com.ruzhan.jsonfile.data.RunningWild;
import com.ruzhan.jsonfile.data.ScamCity;
import com.ruzhan.jsonfile.data.ScamCity2;
import com.ruzhan.jsonfile.data.StoryOfCapital;
import com.ruzhan.jsonfile.data.TED2016;
import com.ruzhan.jsonfile.data.TED2017;
import com.ruzhan.jsonfile.data.TED2018;
import com.ruzhan.jsonfile.data.TheBleedingEdge;
import com.ruzhan.jsonfile.data.TheCove;
import com.ruzhan.jsonfile.data.TheHunt;
import com.ruzhan.jsonfile.data.TheLieWeLive;
import com.ruzhan.jsonfile.data.TheLionSleepsNoMore;
import com.ruzhan.jsonfile.data.TheMonkeyKing;
import com.ruzhan.jsonfile.data.TheOrionConspiracy;
import com.ruzhan.jsonfile.data.TheSecret;
import com.ruzhan.jsonfile.data.TheStoryOfGod;
import com.ruzhan.jsonfile.data.ThreeCountries;
import com.ruzhan.jsonfile.data.Thrive;
import com.ruzhan.jsonfile.data.ThroughTheWormhole;
import com.ruzhan.jsonfile.data.ValeriyBabich;
import com.ruzhan.jsonfile.data.WeGotNext;
import com.ruzhan.jsonfile.data.Weapon;
import com.ruzhan.jsonfile.data.WildChina;
import com.ruzhan.jsonfile.data.WorldOfBlood;
import com.ruzhan.jsonfile.model.HttpResult;
import com.ruzhan.jsonfile.model.Movie;
import com.ruzhan.jsonfile.model.MovieDetail;
import com.ruzhan.jsonfile.utils.JsonFileIOUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ruzhan123 on 2018/7/3.
 */
public final class MovieHelper {

    private static final int PAGE_COUNT = 60;

    private MovieHelper() {

    }

    public static void movieDetailListToJsonFile(List<MovieDetail> list,
                                                 String rootPath, Gson gson) {
        for (MovieDetail movieDetail : list) {
            String name = movieDetail.movieId.concat(CreateJsonMain.FILE_TYPE);
            String filePath = rootPath.concat("\\").concat(name);
            HttpResult<MovieDetail> httpResult = new HttpResult<>(CreateJsonMain.CODE_SUCCESS,
                    "", movieDetail);
            String fileJson = gson.toJson(httpResult);
            boolean isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson);
            System.out.println("isKeyPageSuccess:" + isKeyPageSuccess + ", movieDetailListToJsonFile write !!!");
        }
    }

    public static void movieListToJsonFile(Map<String, List<Movie>> map, String rootPath, Gson gson) {
        Set<Map.Entry<String, List<Movie>>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, List<Movie>>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Movie>> entry = iterator.next();
            String keyPage = entry.getKey();
            List<Movie> valueMovieList = entry.getValue();
            String filePath = rootPath.concat("\\").concat(keyPage).concat(CreateJsonMain.FILE_TYPE);
            HttpResult<List<Movie>> httpResult = new HttpResult<>(CreateJsonMain.CODE_SUCCESS,
                    "", valueMovieList);
            String fileJson = gson.toJson(httpResult);
            boolean isKeyPageSuccess = JsonFileIOUtils.writeFileFromString(filePath, fileJson);
            System.out.println("isKeyPageSuccess:" + isKeyPageSuccess + ", keyPage:" + keyPage);
        }
    }

    public static Map<String, List<Movie>> getMovieMap(List<Movie> list) {
        Map<String, List<Movie>> map = new HashMap<>();
        int page = 1;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Movie> valueList = map.get(String.valueOf(page));
            if (valueList == null) {
                valueList = new ArrayList<>();
            }
            Movie movie = list.get(i);
            valueList.add(movie);
            map.put(String.valueOf(page), valueList);
            count++;

            if (count >= PAGE_COUNT) {
                count = 0;
                page++;
            }
        }
        return map;
    }

    public static List<Movie> getMovieList() {
        List<Movie> list = new ArrayList<>();
        list.add(TheLionSleepsNoMore.movie);
        list.add(NikolaTesla.movie);
        list.add(Thrive.movie);
        list.add(TED2018.movie);
        list.add(TED2017.movie);
        list.add(TED2016.movie);
        list.add(CosmicDisclosure.movie);
        list.add(CosmicDisclosure2.movie);
        list.add(Interstella.movie);
        list.add(DaftPunk.movie);
        list.add(Human.movie);
        list.add(TheSecret.movie);
        //list.add(SouthPark.movie);
        list.add(AliensMoon.movie);
        list.add(AncientAliens.movie);
        list.add(MadeUsSpend.movie);
        list.add(RichAndUs.movie);
        list.add(WildChina.movie);
        list.add(ScamCity.movie);
        list.add(ScamCity2.movie);
        list.add(WorldOfBlood.movie);
        list.add(HiddenLife.movie);
        list.add(TheBleedingEdge.movie);
        list.add(Monsanto.movie);
        list.add(StoryOfCapital.movie);
        list.add(ValeriyBabich.movie);
        list.add(Weapon.movie);
        list.add(RealWar.movie);
        list.add(CunkOnBritain.movie);
        list.add(CredoMutwa.movie);
        list.add(TheOrionConspiracy.movie);
        list.add(KeJi.movie);
        list.add(TheLieWeLive.movie);
        list.add(PunPun.movie);
        list.add(AYearinSpace.movie);
        list.add(LifeIsFruity.movie);
        list.add(OldGuang.movie);
        list.add(ManVsWild.movie);
        list.add(ManVsWild2.movie);
        list.add(EscapeFromHell.movie);
        list.add(RunningWild.movie);
        list.add(NakedCastaway.movie);
        list.add(JamesCameron.movie);
        list.add(Marvel.movie);
        list.add(WeGotNext.movie);
        list.add(DevinWilliams.movie);
        list.add(TheStoryOfGod.movie);
        list.add(ThroughTheWormhole.movie);
        list.add(OnTheRoad.movie);
        list.add(ThreeCountries.movie);
        list.add(TheCove.movie);
        list.add(FrozenPlanet.movie);
        list.add(TheHunt.movie);
        list.add(Africa.movie);
        list.add(TheMonkeyKing.movie);
        return list;
    }

    public static List<MovieDetail> getMovieDetailList() {
        List<MovieDetail> list = new ArrayList<>();
        list.add(TheLionSleepsNoMore.movieDetail);
        list.add(NikolaTesla.movieDetail);
        list.add(Thrive.movieDetail);
        list.add(TED2018.movieDetail);
        list.add(TED2017.movieDetail);
        list.add(TED2016.movieDetail);
        list.add(CosmicDisclosure.movieDetail);
        list.add(CosmicDisclosure2.movieDetail);
        list.add(Interstella.movieDetail);
        list.add(DaftPunk.movieDetail);
        list.add(Human.movieDetail);
        list.add(TheSecret.movieDetail);
        //list.add(SouthPark.movieDetail);
        list.add(AliensMoon.movieDetail);
        list.add(AncientAliens.movieDetail);
        list.add(MadeUsSpend.movieDetail);
        list.add(RichAndUs.movieDetail);
        list.add(WildChina.movieDetail);
        list.add(ScamCity.movieDetail);
        list.add(ScamCity2.movieDetail);
        list.add(WorldOfBlood.movieDetail);
        list.add(HiddenLife.movieDetail);
        list.add(TheBleedingEdge.movieDetail);
        list.add(Monsanto.movieDetail);
        list.add(StoryOfCapital.movieDetail);
        list.add(ValeriyBabich.movieDetail);
        list.add(Weapon.movieDetail);
        list.add(RealWar.movieDetail);
        list.add(CunkOnBritain.movieDetail);
        list.add(CredoMutwa.movieDetail);
        list.add(TheOrionConspiracy.movieDetail);
        list.add(KeJi.movieDetail);
        list.add(TheLieWeLive.movieDetail);
        list.add(PunPun.movieDetail);
        list.add(AYearinSpace.movieDetail);
        list.add(LifeIsFruity.movieDetail);
        list.add(OldGuang.movieDetail);
        list.add(ManVsWild.movieDetail);
        list.add(ManVsWild2.movieDetail);
        list.add(EscapeFromHell.movieDetail);
        list.add(RunningWild.movieDetail);
        list.add(NakedCastaway.movieDetail);
        list.add(JamesCameron.movieDetail);
        list.add(Marvel.movieDetail);
        list.add(WeGotNext.movieDetail);
        list.add(DevinWilliams.movieDetail);
        list.add(TheStoryOfGod.movieDetail);
        list.add(ThroughTheWormhole.movieDetail);
        list.add(OnTheRoad.movieDetail);
        list.add(ThreeCountries.movieDetail);
        list.add(TheCove.movieDetail);
        list.add(FrozenPlanet.movieDetail);
        list.add(TheHunt.movieDetail);
        list.add(Africa.movieDetail);
        list.add(TheMonkeyKing.movieDetail);
        return list;
    }
}
