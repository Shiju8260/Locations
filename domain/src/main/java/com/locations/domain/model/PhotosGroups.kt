package com.locations.domain.model

import com.google.gson.annotations.SerializedName

data class PhotosGroups(
    var count: Int = 0,
    var items: MutableList<PhotosGroupsItems> = mutableListOf()
)
