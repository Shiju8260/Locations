package com.locations.data.model.VenueDetails

import com.google.gson.annotations.SerializedName

data class VenueDetailsEntity(
    @SerializedName("response")
    var response: VenueDetailsResponseEntity = VenueDetailsResponseEntity()
)
