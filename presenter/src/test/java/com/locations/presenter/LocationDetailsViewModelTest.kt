package com.locations.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.domain.model.Venue
import com.locations.domain.usecase.VenueDetailsUseCase
import com.locations.presenter.locationdetails.viewmodel.LocationDetailViewModel
import junit.framework.Assert
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.After
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
class LocationDetailsViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: LocationDetailViewModel

    @Mock
    private lateinit var useCase: VenueDetailsUseCase

    @Before
    fun setup() {
        viewModel = LocationDetailViewModel(useCase)
    }

    @Test
    fun `test getVenueDetail response without null result`() {

        val emptyResponse = Venue()

        testCoroutineRule.runBlockingTest {
            viewModel.mVenueResponseLiveData.observeForever {}
            Mockito.`when`(useCase.getVenueDetails("", mapOf())).thenAnswer {
                flowOf(Response.success(VenueDetails()))
            }
            viewModel.getVenueDetails("")
            Assert.assertNotNull(viewModel.mVenueResponseLiveData.value)
            Assert.assertEquals(emptyResponse, viewModel.mVenueResponseLiveData.value)
        }
    }


}