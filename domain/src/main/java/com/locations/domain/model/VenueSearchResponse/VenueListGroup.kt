package com.locations.domain.model.VenueSearchResponse

import com.google.gson.annotations.SerializedName

data class VenueListGroup(
    var items: MutableList<VenueListItem> = mutableListOf()
)
