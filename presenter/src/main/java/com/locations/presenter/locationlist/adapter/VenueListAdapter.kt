package com.locations.presenter.locationlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.locations.domain.model.Venue
import com.locations.domain.model.VenueSearchResponse.VenueListItem
import com.locations.presenter.BR
import com.locations.presenter.R
import com.locations.presenter.databinding.LayoutVenueListItemBinding
import javax.inject.Inject

class VenueListAdapter @Inject constructor(var onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<VenueListAdapter.ViewHolder>() {

    private var venueList: MutableList<VenueListItem> = mutableListOf()

    //Loading data foe venue listafter API Response
    @SuppressLint("NotifyDataSetChanged")
    fun loadData(venueList: MutableList<VenueListItem>) {
        this.venueList = venueList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueListAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<LayoutVenueListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_venue_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VenueListAdapter.ViewHolder, position: Int) {
        val venueList = venueList[position]
        holder.bind(venueList.venue)
    }

    override fun getItemCount(): Int {
        return venueList.size
    }

    inner class ViewHolder(private var layoutVenueListItemBinding: LayoutVenueListItemBinding) :
        RecyclerView.ViewHolder(layoutVenueListItemBinding.root) {
        fun bind(value: Venue) {
            layoutVenueListItemBinding.setVariable(BR.model, value)
            layoutVenueListItemBinding.executePendingBindings()
            layoutVenueListItemBinding.venueCard.setOnClickListener {
                onItemClickListener.onItemClick(value)
            }
        }
    }


    interface OnItemClickListener {
        fun onItemClick(venue: Venue)
    }
}

