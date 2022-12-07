// package RadioEntities

/***
 * @author cynth
 * @since 2022-12-01
 */

import {RadioBrowserApi, StationSearchType} from 'radio-browser-api'


// This entire page will contain the various sorts of functions that will be required by other classes in this project.
// The list is as follows:
// > Function to input various search terms, and get various items back

const api = new RadioBrowserApi('My Radio App')

const stations = await api.searchStations({
    countryCode: 'US',
    limit: 100,
    offset: 0 // this is the default - can be omited
})

await api.getStationsBy(StationSearchType.byTag, 'jazz')

console.log(stations)

/*
async function getRadioStationSelection() {
    const getStations = await api.getStationsByVotes({
        limit: 50
    })

    return getStations;
}

const getStations = await api.getStationsByVotes({
    limit: 50
})

return getStations;*/

/*
const jetpack = require("fs-jetpack");
var stationSelection = getRadioStationSelection();

jetpack.write("src/main/java/entities/radio_entities/RadioStationSelection", stationSelection)*/
