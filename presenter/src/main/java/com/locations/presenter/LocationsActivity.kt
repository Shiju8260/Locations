package com.locations.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.locations.presenter.locationlist.view.LocationsListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)

    }
}