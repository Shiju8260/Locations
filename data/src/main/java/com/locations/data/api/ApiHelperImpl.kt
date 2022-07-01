package com.locations.data.api

import com.locations.data.model.VenueDetails.VenueDetailsEntity
import com.locations.data.model.VenueSearchResponse.VenueSearchResponseEntity
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getVenueList(paramMap: Map<String, String>): Response<VenueSearchResponseEntity> =
        apiService.getVenueList(paramMap = paramMap)

    override suspend fun getVenueDetails(
        venueId: String
    ): Response<VenueDetailsEntity> =
        apiService.getVenueDetails(venueId = venueId)


}