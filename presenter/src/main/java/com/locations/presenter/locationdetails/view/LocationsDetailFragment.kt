package com.locations.presenter.locationdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.locations.presenter.R
import com.locations.presenter.base.BaseFragment
import com.locations.presenter.databinding.FragmentLocationDetailsBinding
import com.locations.presenter.databinding.FragmentLocationsListBinding
import com.locations.presenter.extension.hide
import com.locations.presenter.extension.show
import com.locations.presenter.locationdetails.viewmodel.LocationDetailViewModel
import com.locations.presenter.utils.ConnectivityUtil
import com.locations.presenter.utils.Constants
import com.locations.presenter.utils.NetworkState
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Array.get

@AndroidEntryPoint
class LocationsDetailFragment: BaseFragment<FragmentLocationDetailsBinding>()  {

    private lateinit var viewModel: LocationDetailViewModel
    private lateinit var navController: NavController
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLocationDetailsBinding
    get() = FragmentLocationDetailsBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LocationDetailViewModel::class.java)
        navController = NavHostFragment.findNavController(this)
        checkNetworkState()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setHomeButton(true)
        setHasOptionsMenu(true)
        initObserver()
    }

    private fun checkNetworkState() {
        if (ConnectivityUtil.isConnected(activity))
            arguments?.getString("venueId")?.let { viewModel.getVenueDetails(it) }
        else
            errorUI(Constants.TXT_NETWORK_ERROR)
    }

    private fun setHomeButton(enable: Boolean) {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(enable)
        (activity as AppCompatActivity).supportActionBar?.setHomeButtonEnabled(enable)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setHomeButton(false)
    }

    private fun initObserver() {
        viewModel.mNetworkStateLiveData.observeForever {
            when (it) {
                is NetworkState.LOADING -> {
                    binding.progressBar.show()
                    binding.mainContent.hide()
                    binding.txtEmptyMessage.hide()
                }
                is NetworkState.ERROR -> {
                    errorUI(it.msg)
                }
                is NetworkState.LOADED -> {
                    binding.progressBar.hide()
                    binding.mainContent.show()
                    binding.txtEmptyMessage.hide()
                }
            }
        }
    }

    private fun errorUI(msg: String) {
        binding.progressBar.hide()
        binding.mainContent.hide()
        binding.txtEmptyMessage.show()
        binding.txtEmptyMessage.text = msg
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            navController.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
}