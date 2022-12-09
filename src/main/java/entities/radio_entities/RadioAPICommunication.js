// package RadioEntities

/***
 * @author cynth
 */

import { RadioBrowserApi } from 'radio-browser-api'

/**
 * The purpose of this file was to be the place where the JS commands for the API
 * could be communicated. This has not been fully implemented yet, and thus it was
 * most recently used to gather the information that was used to create the RadioStation
 * objects present in StationLibrary.
 *
 * @type {RadioBrowserApi}
 */

const api = new RadioBrowserApi('My Radio App')

const stations = await api.searchStations({
    countryCode: 'US',
    limit: 100,
    offset: 1 // 1 - is the second page
})

console.log(stations);
