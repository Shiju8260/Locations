package com.locations.presenter.locationlist.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.locations.domain.model.Venue
import com.locations.presenter.R
import com.locations.presenter.base.BaseFragment
import com.locations.presenter.databinding.FragmentLocationsListBinding
import com.locations.presenter.extension.hide
import com.locations.presenter.extension.show
import com.locations.presenter.locationlist.adapter.VenueListAdapter
import com.locations.presenter.locationlist.viewmodel.LocationsListViewModel
import com.locations.presenter.utils.ConnectivityUtil
import com.locations.presenter.utils.Constants
import com.locations.presenter.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationsListFragment : BaseFragment<FragmentLocationsListBinding>(), VenueListAdapter.OnItemClickListener {

    private lateinit var venueListAdapter: VenueListAdapter
    private lateinit var navController: NavController
    private lateinit var viewModel: LocationsListViewModel

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLocationsListBinding
        get() = FragmentLocationsListBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(LocationsListViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        checkNetworkState()
        venueListAdapter = VenueListAdapter(this)
        binding.venueList.adapter = venueListAdapter
        binding.venueList.layoutManager = LinearLayoutManager(activity)
        binding.venueList.addItemDecoration(
            DividerItemDecoration(
                binding.venueList.context, 0
            )
        )
        initObserver()
    }

    private fun checkNetworkState() {
        if (ConnectivityUtil.isConnected(activity))
            viewModel.getVenueList()
        else
            errorUI(Constants.TXT_NETWORK_ERROR)
    }

    private fun initObserver() {
        viewModel.mVenueListResponseLiveData.observeForever {
            venueListAdapter.loadData(venueList = it)
        }
        viewModel.mNetworkStateLiveData.observeForever {
            when (it) {
                is NetworkState.LOADING -> {
                    binding.progressBar.show()
                    binding.venueList.hide()
                    binding.txtEmptyMessage.hide()
                }
                is NetworkState.ERROR -> {
                    errorUI(it.msg)
                }
                is NetworkState.LOADED -> {
                    binding.progressBar.hide()
                    binding.venueList.show()
                    binding.txtEmptyMessage.hide()
                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        //SearchView on menu
        val search = menu.findItem(R.id.appSearchBar)
        val searchView = search.actionView as SearchView
        searchView.queryHint = getString(R.string.txt_Search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setLocation(query?:"")
                checkNetworkState()
                searchView.onActionViewCollapsed()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun errorUI(msg: String) {
        binding.progressBar.hide()
        binding.venueList.hide()
        binding.txtEmptyMessage.show()
        binding.txtEmptyMessage.text = msg
    }

    override fun onItemClick(venue: Venue) {
        val action = LocationsListFragmentDirections.venueDetailsAction(venue.venueUniqId)
        navController.navigate(action)
    }



}