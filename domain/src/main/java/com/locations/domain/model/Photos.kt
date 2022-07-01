package com.locations.domain.model

import com.google.gson.annotations.SerializedName

data class Photos(
    var count: Int = 0,
    var groups: MutableList<PhotosGroups> = mutableListOf()
)
