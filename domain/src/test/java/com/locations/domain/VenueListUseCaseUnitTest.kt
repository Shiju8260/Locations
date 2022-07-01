package com.locations.domain


import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.domain.repository.VenueListRepository
import com.locations.domain.usecase.VenueListUseCase
import com.locations.domain.usecase.VenueListUseCaseImpl
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
class VenueListUseCaseUnitTest {

    @Mock
    lateinit var repository: VenueListRepository

    lateinit var useCase: VenueListUseCase

    @Before
    fun setUp() {
        useCase = VenueListUseCaseImpl(repository)
    }

    @Test
    fun `test venuelistusecase response without null result`() {
        runBlocking {
            val mockResult =
                flowOf(Response.success(VenueSearchResponse()))
            Mockito.`when`(repository.getVenueList(mapOf())).thenReturn(mockResult)
            val useCaseData = useCase.getVenueList(mapOf())
            assert(useCaseData == mockResult)
        }
    }
}