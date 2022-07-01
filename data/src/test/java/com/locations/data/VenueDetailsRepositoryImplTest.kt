package com.locations.data

import com.locations.data.api.ApiHelper
import com.locations.data.mapper.DataToDomainModelMapper
import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.data.repository.VenueDetailsRepositoryImpl
import com.locations.domain.repository.VenueDetailsRepository
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
class VenueDetailsRepositoryImplTest {
    private lateinit var repository: VenueDetailsRepository

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    internal lateinit var modelMapper: DataToDomainModelMapper

    @Mock
    internal lateinit var venueDetailsResult: Flow<Response<VenueDetails>>

    @Mock
    internal lateinit var apiHelper: ApiHelper


    @Before
    fun setUp() {
        repository = VenueDetailsRepositoryImpl(apiHelper, modelMapper)
    }

    @Test
    fun `test venuelistrepository response without null result`() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(repository.getVenueDetails("", mapOf())).thenReturn(venueDetailsResult)
            val responseFlow = repository.getVenueDetails("", mapOf())
            assert(venueDetailsResult == responseFlow)
        }
    }
}