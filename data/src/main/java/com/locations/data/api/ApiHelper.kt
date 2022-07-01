package com.locations.data.api

import com.locations.data.model.VenueDetails.VenueDetailsEntity
import com.locations.data.model.VenueSearchResponse.VenueSearchResponseEntity
import retrofit2.Response

interface ApiHelper {

    suspend fun getVenueList(paramMap: Map<String, String>): Response<VenueSearchResponseEntity>
    suspend fun getVenueDetails(
        venueId: String
    ): Response<VenueDetailsEntity>


}