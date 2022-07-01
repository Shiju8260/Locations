package com.locations.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @SerializedName("formattedAddress")
    @Expose
    var formattedAddress: List<String> = listOf()
)