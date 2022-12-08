package abr.radio_abr;
import entities.radio_entities.RadioStation;

import java.util.ArrayList;
import java.util.List;

/***
 * @author cynth
 * @since 2022-12-01
 */

// TODO: Javadocs
public class StationLibrary {
    private static ArrayList<RadioStation> stations;

    public List<RadioStation> getStations() {

        List<RadioStation> radioStationList = new ArrayList<>();

        // If the API call was working it would go here, and we would be able to add and create the Radio Station objects here.
        // However, as that is not working, for demonstration purposes to show how the rest of the program works, I will be
        // manually referencing the API to create RadioStation objects for testing.

        RadioStation station1 = new RadioStation(
                "42dea578-0099-4728-929e-8e0e02bebc18",
                "102.1 KOKY-FM",
                "https://18863.live.streamtheworld.com:443/KOKYFMAAC.aac");

        RadioStation station2 = new RadioStation(
                "96edc4bf-7a03-4c79-8b4f-2bb455826e76",
                "102.1 The Fox",
                "https://15313.live.streamtheworld.com:443/WMXTFMAAC.aac");

        RadioStation station3 = new RadioStation(
                "7558a9d8-9aa3-45cb-b307-d9cc97870f2d",
                "1011 The Beat",
                "https://n35a-e2.revma.ihrhls.com/zc2153?rj-ttl=5&rj-tok=AAABhO5v6QEAndTWqRkpRI2qHg");

        RadioStation station4 = new RadioStation(
                "e35c3d73-0d68-4d2c-90fc-c91466602f2e",
                "101.9 The Twister",
                "https://n19a-e2.revma.ihrhls.com/zc1913?rj-ttl=5&rj-tok=AAABhOyC6hEA2fwbVIVCXU6A2Q");

        RadioStation station5 = new RadioStation(
                "cacf6613-10e5-483f-ba98-17c15bb823b9",
                "101.9 KISS FM",
                "https://n1ba-e2.revma.ihrhls.com/zc4864?rj-ttl=5&rj-tok=AAABhOrzCHoAfsG0msnP2oYtVg");

        radioStationList.add(station1);
        radioStationList.add(station2);
        radioStationList.add(station3);
        radioStationList.add(station4);
        radioStationList.add(station5);

        return radioStationList;

        }

}
