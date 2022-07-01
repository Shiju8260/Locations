package com.locations.domain.repository

import com.locations.data.model.VenueDetails.VenueDetails
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface VenueDetailsRepository {
    suspend fun getVenueDetails(
        venueId: String
    ): Flow<Response<VenueDetails>>

}