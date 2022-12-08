// package RadioEntities

/***
 * @author cynth
 */

import { RadioBrowserApi } from 'radio-browser-api'

// This entire page will contain the various sorts of functions that will be required by other classes in this project.
// The list is as follows:
// > Function to input various search terms, and get various items back

const api = new RadioBrowserApi('My Radio App')

const stations = await api.searchStations({
    countryCode: 'US',
    limit: 100,
    offset: 0 // this is the default - can be omited
})

console.log(stations)
