package com.locations.data.repository

import com.locations.data.api.ApiHelper
import com.locations.data.mapper.DataToDomainModelMapper
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.domain.repository.VenueListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class VenueListRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val mapper: DataToDomainModelMapper
) : VenueListRepository {
    override suspend fun getVenueList(query: Map<String, String>): Flow<Response<VenueSearchResponse>> {
        return flow {
            emit(apiHelper.getVenueList(query).let { mapper.mapDataVenueListToDomainVenueList(it) })
        }.flowOn(Dispatchers.IO)
    }
}