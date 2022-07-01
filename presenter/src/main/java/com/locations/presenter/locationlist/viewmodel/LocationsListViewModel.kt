package com.locations.presenter.locationlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.domain.model.VenueSearchResponse.VenueListGroup
import com.locations.domain.model.VenueSearchResponse.VenueListItem
import com.locations.domain.usecase.VenueListUseCase
import com.locations.presenter.utils.Constants
import com.locations.presenter.utils.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsListViewModel @Inject constructor(private val venueListUseCase: VenueListUseCase) :
    ViewModel() {

    private val mVenueListResponse: MutableLiveData<MutableList<VenueListItem>> = MutableLiveData()
    val mVenueListResponseLiveData: LiveData<MutableList<VenueListItem>> by lazy { mVenueListResponse }

    private val mNetworkState: MutableLiveData<NetworkState> = MutableLiveData()
    val mNetworkStateLiveData: LiveData<NetworkState> by lazy { mNetworkState }

    fun getVenueList() {
        viewModelScope.launch {
            mNetworkState.value = NetworkState.LOADING
            venueListUseCase.getVenueList(getRequestParamForVenueList()).collect { response ->
                if (response.isSuccessful) {
                    mNetworkState.value = NetworkState.LOADED
                    val venueSearchResponse: VenueSearchResponse? = response.body()
                    val venueListGroups: MutableList<VenueListGroup> =
                        venueSearchResponse?.responseData?.groups ?: mutableListOf()
                    if (venueListGroups.size > 0 && venueListGroups.get(0).items.size > 0) {
                        mVenueListResponse.value = venueListGroups.get(0).items
                    } else {
                        mNetworkState.value = NetworkState.ERROR(Constants.TXT_DATA_NOT_AVAILABLE)
                    }
                } else {
                    mNetworkState.value =
                        NetworkState.ERROR(response.message() ?: Constants.TXT_DATA_NOT_AVAILABLE)
                }
            }
        }
    }

    //Request params for venue list
    private fun getRequestParamForVenueList(): Map<String, String> {
        val query: HashMap<String, String> = HashMap()
        query[Constants.PARAM_INTENT] = "browse"
        query[Constants.PARAM_NEAR] = "Minneapolis"
        query[Constants.PARAM_RADIUS] = "10000"
        query[Constants.PARAM_LIMIT] = "10"
        query[Constants.PARAM_VENUEPHOTOS] = "1"
        return query
    }
}