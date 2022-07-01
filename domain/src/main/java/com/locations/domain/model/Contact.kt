package com.locations.data.model


data class Contact(
    var facebook: String = "",
    var facebookName: String = "",
    var facebookUsername: String? = null,
    var formattedPhone: String? = null,
    var instagram: String? = null,
    var phone: String? = null,
    var twitter: String? = null
)