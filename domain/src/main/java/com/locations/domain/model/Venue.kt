package com.locations.domain.model


import androidx.databinding.ObservableField
import com.locations.data.model.BestPhoto
import com.locations.data.model.Contact
import com.locations.data.model.Location

data class Venue(
    var venueUniqId: String = "",
    var rating: Float = 0.0F,
    var ratingColor: String = "",
    var description: String? = null,
    var location: Location = Location(),
    var contact: Contact = Contact(),
    var bestPhoto: BestPhoto = BestPhoto(),
    var photos: Photos = Photos(),
    var name: String = ""
)
