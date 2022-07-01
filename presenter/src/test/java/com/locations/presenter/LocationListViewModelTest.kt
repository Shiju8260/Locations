package com.locations.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import co.cdmunoz.nasaroverphotos.utils.TestCoroutineRule
import co.cdmunoz.nasaroverphotos.utils.runBlockingTest
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.domain.model.VenueSearchResponse.VenueListItem
import com.locations.domain.usecase.VenueListUseCase
import com.locations.presenter.locationlist.viewmodel.LocationsListViewModel
import com.locations.presenter.utils.Constants
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import org.mockito.Mockito.`when` as whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class LocationListViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var viewModel: LocationsListViewModel

    @Mock
    private lateinit var useCase: VenueListUseCase

    @Mock
    private lateinit var venueListResponseObserver: Observer<MutableList<VenueListItem>>

    @Before
    fun setup() {
        viewModel = LocationsListViewModel(useCase)
    }

    @Test
    fun `test getVenueList response without null result`() {

        val emptyList = mutableListOf<VenueListItem>()

        testCoroutineRule.runBlockingTest {
            viewModel.mVenueListResponseLiveData.observeForever(venueListResponseObserver)
            whenever(useCase.getVenueList(mapOf())).thenAnswer {
                flowOf(Response.success(emptyList))
            }
            viewModel.getVenueList()
            assertNotNull(viewModel.mVenueListResponseLiveData.value)
            assertEquals(emptyList, viewModel.mVenueListResponseLiveData.value)
        }
    }


}