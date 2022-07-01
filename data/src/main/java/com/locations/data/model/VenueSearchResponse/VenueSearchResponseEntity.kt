package com.locations.data.model.VenueSearchResponse


import com.google.gson.annotations.SerializedName

data class VenueSearchResponseEntity(
    @SerializedName("response")
    var responseEntity: ResponseEntity = ResponseEntity()
)
