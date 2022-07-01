package com.locations.data.model.VenueSearchResponse

import com.google.gson.annotations.SerializedName

data class VenueListGroupEntity(
    @SerializedName("items")
    var items: MutableList<VenueListItemEntity> = mutableListOf()
)
