package com.locations.domain

import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.domain.repository.VenueDetailsRepository
import com.locations.domain.usecase.VenueDetailsUseCase
import com.locations.domain.usecase.VenueDetailsUseCaseImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class VenueDetailsUseCaseUnitTest {
    @Mock
    lateinit var repository: VenueDetailsRepository

    lateinit var useCase: VenueDetailsUseCase

    @Before
    fun setUp() {
        useCase = VenueDetailsUseCaseImpl(repository)
    }

    @Test
    fun `test venuelistusecase response without null result`() {
        runBlocking {
            val mockResult =
                flowOf(Response.success(VenueDetails()))
            Mockito.`when`(repository.getVenueDetails("", mapOf())).thenReturn(mockResult)
            val useCaseData = useCase.getVenueDetails("", mapOf())
            assert(useCaseData == mockResult)
        }
    }
}