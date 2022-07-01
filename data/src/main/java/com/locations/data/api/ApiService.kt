package com.locations.data.api

import com.locations.data.model.VenueDetails.VenueDetailsEntity
import com.locations.data.model.VenueSearchResponse.VenueSearchResponseEntity
import com.locations.data.utils.ApiConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {
    @GET(ApiConfig.VENUE_LIST_ENDPOINT)
    suspend fun getVenueList(
        @Query("v") version: String = ApiConfig.VERSION,
        @Query("client_id") clientId: String = ApiConfig.CLIENT_ID,
        @Query("client_secret") clientSecret: String = ApiConfig.CLIENT_SECRET,
        @QueryMap paramMap: Map<String, String>
    ): Response<VenueSearchResponseEntity>

    @GET(ApiConfig.VENUE_DETAILS_ENDPOINT)
    suspend fun getVenueDetails(
        @Path("venueId") venueId: String,
        @Query("v") version: String = ApiConfig.VERSION,
        @Query("client_id") clientId: String = ApiConfig.CLIENT_ID,
        @Query("client_secret") clientSecret: String = ApiConfig.CLIENT_SECRET
    ): Response<VenueDetailsEntity>

}