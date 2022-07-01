package com.locations.data.model

import com.google.gson.annotations.SerializedName

data class PhotosGroupsItemsEntity(
    @SerializedName("width")
    var width: String = "",
    @SerializedName("height")
    var height: String = "",
    @SerializedName("prefix")
    var prefix: String = "",
    @SerializedName("suffix")
    var suffix: String = ""
)
