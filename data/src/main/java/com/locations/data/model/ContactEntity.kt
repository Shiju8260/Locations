package com.locations.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ContactEntity(
    @SerializedName("facebook")
    var facebook: String = "",
    @SerializedName("facebookName")
    var facebookName: String = "",
    @SerializedName("facebookUsername")
    var facebookUsername: String? = null,
    @SerializedName("formattedPhone")
    var formattedPhone: String? = null,
    @SerializedName("instagram")
    var instagram: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("twitter")
    var twitter: String? = null
)