package com.locations.domain.usecase

import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.domain.repository.VenueListRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

internal class VenueListUseCaseImpl @Inject constructor(private val venueListRepository: VenueListRepository) :
    VenueListUseCase {

    override suspend fun getVenueList(query: Map<String, String>): Flow<Response<VenueSearchResponse>> {
        return venueListRepository.getVenueList(query)
    }
}