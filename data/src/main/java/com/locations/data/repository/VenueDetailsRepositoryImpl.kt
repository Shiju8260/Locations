package com.locations.data.repository

import com.locations.data.api.ApiHelper
import com.locations.data.mapper.DataToDomainModelMapper
import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.domain.repository.VenueDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class VenueDetailsRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val mapper: DataToDomainModelMapper
) : VenueDetailsRepository {

    override suspend fun getVenueDetails(
        venueId: String
    ): Flow<Response<VenueDetails>> {
        return flow {
            emit(
                apiHelper.getVenueDetails(venueId = venueId)
                    .let { mapper.mapDataVenueDetailToDomainVenueDetail(it) })
        }.flowOn(Dispatchers.IO)
    }

}