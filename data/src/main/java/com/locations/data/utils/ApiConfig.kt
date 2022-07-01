package com.locations.data.utils

class ApiConfig {
    companion object {
        const val BASE_URL = "https://api.foursquare.com/v2/"
        const val CLIENT_ID = "5PI3KXH02V1F4YRO1YRY44LAS0QVQLBKPU0I2OPBTIBWIMEK"
        const val CLIENT_SECRET = "5GSSEEXFHGGC3VH3JTX5L4OXWUC1CZABUVNU153RWLH1V0VX"
        const val VERSION = "20210302"
        const val VENUE_LIST_ENDPOINT = "venues/explore"
        const val VENUE_DETAILS_ENDPOINT = "venues/{venueId}?"
    }
}