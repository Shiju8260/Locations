package com.locations.data.model


import com.google.gson.annotations.SerializedName
import com.locations.data.model.BestPhoto
import com.locations.data.model.Contact
import com.locations.data.model.Location

data class VenueEntity(
    @SerializedName("id")
    var venueUniqId: String = "",
    @SerializedName("rating")
    var rating: Double = 0.0,
    @SerializedName("ratingColor")
    var ratingColor: String = "",
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("location")
    var locationEntity: LocationEntity = LocationEntity(),
    @SerializedName("contact")
    var contactEntity: ContactEntity = ContactEntity(),
    @SerializedName("bestPhoto")
    var bestPhotoEntity: BestPhotoEntity = BestPhotoEntity(),
    @SerializedName("photos")
    var photosEntity: PhotosEntity = PhotosEntity(),
    @SerializedName("name")
    var name: String = ""
)
