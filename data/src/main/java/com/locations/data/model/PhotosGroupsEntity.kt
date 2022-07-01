package com.locations.data.model

import com.google.gson.annotations.SerializedName

data class PhotosGroupsEntity(
    @SerializedName("count")
    var count: Int = 0,
    @SerializedName("items")
    var items: MutableList<PhotosGroupsItemsEntity> = mutableListOf()
)
