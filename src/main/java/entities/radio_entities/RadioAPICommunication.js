// package RadioEntities

/***
 * @author cynth
 */

import { RadioBrowserApi } from 'radio-browser-api'

// This entire page will contain the various sorts of functions that will be required by other classes in this project.
// The list is as follows:
// > Function to input various search terms, and get various items back

const api = new RadioBrowserApi('My Radio App')

// First, a function that gets a Radio Station by id.
async function getRadioStation(id) {
    const getStation = await api.getStationsById({
        id: id
    })

    return getStation;
}

// The function that just generically searches.
async function searchRadioStation(tags, name, language, country, offset = 0){
    const stations = await api.searchStations({
        countryCode: country,
        language: language,
        name: name,
        tags: [],
        limit: 10,
        offset: offset
    })

    return stations;
}

// The function that takes the exact same queries but just goes to the next page.
async function searchStationNext(tags, name, language, country, offset){
    const stations = await api.searchStations({
        countryCode: country,
        language: language,
        name: name,
        tags: [],
        limit: 10,
        offset: offset + 1
    })

    return stations;
}

// Functions that get all the needed information from a station in question.
async function getStationID(station){
    return station.id;
}

async function getStationName(station){
    return station.name;
}

async function getStationURL(station){
    return station.url;
}

async function getStationImageURL(station){
    return station.favicon;
}