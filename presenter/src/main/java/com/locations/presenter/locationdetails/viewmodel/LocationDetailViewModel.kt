package com.locations.presenter.locationdetails.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locations.domain.model.Venue
import com.locations.domain.usecase.VenueDetailsUseCase
import com.locations.presenter.utils.Constants
import com.locations.presenter.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(private val venueDetailsUseCase: VenueDetailsUseCase) :
    ViewModel() {
    private val mVenueResponse: MutableLiveData<Venue> = MutableLiveData()
    val mVenueResponseLiveData: LiveData<Venue> by lazy { mVenueResponse }

    private val mNetworkState: MutableLiveData<NetworkState> = MutableLiveData()
    val mNetworkStateLiveData: LiveData<NetworkState> by lazy { mNetworkState }


    fun getVenueDetails(venueId: String) {
        viewModelScope.launch {
            mNetworkState.value = NetworkState.LOADING
            venueDetailsUseCase.getVenueDetails(venueId = venueId)
                .collect { response ->
                    Log.v("API response", response.body().toString())

                    if (response.isSuccessful) {
                        mNetworkState.value = NetworkState.LOADED
                        mVenueResponse.value = response.body()?.response?.venue
                    } else {
                        mNetworkState.value =
                            NetworkState.ERROR(
                                response.message() ?: Constants.TXT_DATA_NOT_AVAILABLE
                            )
                    }
                }
        }
    }

}