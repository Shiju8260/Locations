package com.locations.presenter.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.locations.domain.model.Venue
import com.locations.presenter.R

@BindingAdapter("locations:setVenueImage")
fun setVenueImage(imageView: ImageView, model: Venue) {
    val photos = model.photos
    val photosGroups = photos.groups
    if (photosGroups.size > 0 && photosGroups.get(0).items.size > 0) {
        val photosGroupsItems = photosGroups.get(0).items.get(0)
        val sb = StringBuilder()
        sb.append(photosGroupsItems.prefix).append(photosGroupsItems.width).append("x")
            .append(photosGroupsItems.height).append(photosGroupsItems.suffix)
        imageView.load(sb.toString()) {
            placeholder(R.drawable.ic_launcher_background)
        }
    }
}

@BindingAdapter("locations:setVenueDetailsImage")
fun setVenueDetailsImage(imageView: ImageView, model: Venue?) {
    model?.let {
        val bestPhoto = model.bestPhoto
        val sb = StringBuilder()
        sb.append(bestPhoto.prefix).append(bestPhoto.width).append("x")
            .append(bestPhoto.height).append(bestPhoto.suffix)
        imageView.load(sb.toString()) {
            placeholder(R.drawable.ic_launcher_background)
        }
    }
}

@BindingAdapter("locations:setVenueAddress")
fun setVenueAddress(textView: TextView, model: Venue?) {
    model?.let {
        textView.text = it.location.formattedAddress.joinToString()
    }
}