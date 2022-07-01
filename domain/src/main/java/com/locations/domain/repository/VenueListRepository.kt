package com.locations.domain.repository

import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.data.model.VenueDetails.VenueDetailsResponse
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


//Repository for venue list view
interface VenueListRepository {
    suspend fun getVenueList(query: Map<String, String>): Flow<Response<VenueSearchResponse>>
}