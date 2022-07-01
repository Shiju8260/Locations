package com.locations.data.model.VenueDetails

import com.google.gson.annotations.SerializedName
import com.locations.data.model.VenueEntity

data class VenueDetailsResponseEntity(
    @SerializedName("venue")
    var venueEntity: VenueEntity = VenueEntity()
)
