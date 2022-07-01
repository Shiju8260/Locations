package com.locations.data.model.VenueSearchResponse

import com.google.gson.annotations.SerializedName
import com.locations.data.model.VenueEntity

data class VenueListItemEntity(
    @SerializedName("venue")
    var venue: VenueEntity = VenueEntity()
)
