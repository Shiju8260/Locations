package com.locations.data.model

import com.google.gson.annotations.SerializedName
import com.locations.data.model.VenueSearchResponse.VenueListItemEntity

data class PhotosEntity(
    @SerializedName("count")
    var count: Int = 0,
    @SerializedName("groups")
    var groups: MutableList<PhotosGroupsEntity> = mutableListOf()
)
