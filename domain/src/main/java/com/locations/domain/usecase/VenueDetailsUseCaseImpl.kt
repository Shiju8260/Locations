package com.locations.domain.usecase

import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.domain.repository.VenueDetailsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class VenueDetailsUseCaseImpl @Inject constructor(private val venueDetailsRepository: VenueDetailsRepository) :
    VenueDetailsUseCase {

    override suspend fun getVenueDetails(
        venueId: String
    ): Flow<Response<VenueDetails>> {
        return venueDetailsRepository.getVenueDetails(venueId)
    }

}