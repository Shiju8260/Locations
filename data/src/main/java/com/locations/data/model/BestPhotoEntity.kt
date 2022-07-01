package com.locations.data.model

import com.google.gson.annotations.SerializedName

data class BestPhotoEntity(
    @SerializedName("createdAt")
    var createdAt: Int = 0,
    @SerializedName("height")
    var height: Int = 0,
    @SerializedName("prefix")
    var prefix: String = "",
    @SerializedName("suffix")
    var suffix: String = "",
    @SerializedName("visibility")
    var visibility: String = "",
    @SerializedName("width")
    var width: Int = 0
)