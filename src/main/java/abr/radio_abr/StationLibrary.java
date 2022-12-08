package abr.radio_abr;
import entities.radio_entities.RadioStation;

import java.util.ArrayList;
import java.util.List;

/***
 * @author cynth
 * @since 2022-12-01
 */

/**
 * The purpose of this class is to essentially gather the RadioStation data and convert it into a list of RadioStation Objects
 * that can then be used for RadioSearch and beyond. Due to the API implementation being incomplete, the RadioStations we will be
 * using have been hardcoded within for now.
 */

public class StationLibrary {
    private static ArrayList<RadioStation> stations;

    public List<RadioStation> getStations() {

        List<RadioStation> radioStationList = new ArrayList<>();

        // This is where the API calls would come into play. However, for now we will test with these hardcoded RadioStation Objects.
        // The data I am using here does come from the API, but I am inputting it manually.
        RadioStation station1 = new RadioStation(
                "96edc4bf-7a03-4c79-8b4f-2bb455826e76",
                "102.1 The Fox",
                "https://15313.live.streamtheworld.com:443/WMXTFMAAC.aac");

        RadioStation station2 = new RadioStation(
                "b921ad34-bdc0-409a-877d-927d28dd1df2",
                "102 Jams",
                "https://prod-44-201-221-3.wostreaming.net/audacy-krbqfmaac-hlsc.m3u8");

        RadioStation station3 = new RadioStation(
                "7558a9d8-9aa3-45cb-b307-d9cc97870f2d",
                "1011 The Beat",
                "https://n35a-e2.revma.ihrhls.com/zc2153?rj-ttl=5&rj-tok=AAABhO5v6QEAndTWqRkpRI2qHg");

        RadioStation station4 = new RadioStation(
                "835fadbf-2671-45a8-9303-9735452b5ea7",
                "101.9 The Rock",
                "https://prod-34-239-134-247.wostreaming.net/townsquare-wozifmaac-ibc3");

        RadioStation station5 = new RadioStation(
                "7a5aebf3-a427-4773-8d17-6bb6f842653c",
                "100.3 The Bus",
                "https://n26a-e2.revma.ihrhls.com/zc2744?rj-ttl=5&rj-tok=AAABhO7OvxYAVgLt1D_Lr1_MBA");

        radioStationList.add(station1);
        radioStationList.add(station2);
        radioStationList.add(station3);
        radioStationList.add(station4);
        radioStationList.add(station5);

        return radioStationList;

        }

}
