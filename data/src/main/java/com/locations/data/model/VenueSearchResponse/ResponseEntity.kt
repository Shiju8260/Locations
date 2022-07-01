package com.locations.data.model.VenueSearchResponse

import com.google.gson.annotations.SerializedName
import com.locations.data.model.VenueEntity

data class ResponseEntity(
    @SerializedName("groups")
    var groups: MutableList<VenueListGroupEntity> = mutableListOf()
)
