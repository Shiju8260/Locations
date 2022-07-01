package com.locations.data

import com.locations.data.api.ApiHelper
import com.locations.data.mapper.DataToDomainModelMapper
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.data.repository.VenueListRepositoryImpl
import com.locations.domain.repository.VenueListRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class VenueListRepositoryImplTest {
    private lateinit var repository: VenueListRepository

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    internal lateinit var modelMapper: DataToDomainModelMapper

    @Mock
    internal lateinit var venueSearchResult: Flow<Response<VenueSearchResponse>>

    @Mock
    internal lateinit var apiHelper: ApiHelper


    @Before
    fun setUp() {
        repository = VenueListRepositoryImpl(apiHelper, modelMapper)
    }

    @Test
    fun `test venuelistrepository response without null result`() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(repository.getVenueList(mapOf())).thenReturn(venueSearchResult)
            val responseFlow = repository.getVenueList(mapOf())
            assert(venueSearchResult == responseFlow)
        }
    }
}