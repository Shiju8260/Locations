package com.locations.domain.usecase

import com.locations.data.model.VenueDetails.VenueDetails
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface VenueDetailsUseCase {
    suspend fun getVenueDetails(
        venueId: String
    ): Flow<Response<VenueDetails>>

}