package com.locations.presenter.utils

class Constants {
    companion object {

        //API PARAMS
        const val PARAM_NEAR="near"
        const val PARAM_INTENT="intent"
        const val PARAM_RADIUS="radius"
        const val PARAM_LIMIT="limit"
        const val PARAM_VENUEPHOTOS="venuePhotos"

        //API or empty DB error response messages
        const val TXT_DATA_NOT_AVAILABLE="Sorry Data Not Available!"
        const val TXT_NETWORK_ERROR="No internet Connection!"


        //API Paths
        const val API_VENUE_SEARCH="venues/search?"
        const val API_VENUE_DETAILS="venues/{venueId}?"
        const val API_VENUE_ID_PATH_NAME="venueId"

    }

}