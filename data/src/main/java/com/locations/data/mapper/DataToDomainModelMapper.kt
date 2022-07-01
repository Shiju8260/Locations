package com.locations.data.mapper

import com.locations.data.model.*
import com.locations.data.model.VenueDetails.VenueDetails
import com.locations.data.model.VenueDetails.VenueDetailsEntity
import com.locations.data.model.VenueDetails.VenueDetailsResponse
import com.locations.data.model.VenueSearchResponse.VenueListGroupEntity
import com.locations.data.model.VenueSearchResponse.VenueListItemEntity
import com.locations.data.model.VenueSearchResponse.VenueSearchResponse
import com.locations.data.model.VenueSearchResponse.VenueSearchResponseEntity
import com.locations.domain.model.Photos
import com.locations.domain.model.PhotosGroups
import com.locations.domain.model.PhotosGroupsItems
import com.locations.domain.model.Venue
import com.locations.domain.model.VenueSearchResponse.ResponseData
import com.locations.domain.model.VenueSearchResponse.VenueListGroup
import com.locations.domain.model.VenueSearchResponse.VenueListItem
import javax.inject.Inject

class DataToDomainModelMapper @Inject constructor() {

    fun mapDataVenueListToDomainVenueList(venueSearchResponseEntity: retrofit2.Response<VenueSearchResponseEntity>?): retrofit2.Response<VenueSearchResponse> {
        return retrofit2.Response.success(
            VenueSearchResponse(
                responseData = getVenueSearchResponseData(
                    venueSearchResponseEntity?.body()
                )
            )
        )
    }

    private fun getVenueSearchResponseData(venueSearchResponseEntity: VenueSearchResponseEntity?) =
        ResponseData(
            groups = getVenueListGroupResponse(venueSearchResponseEntity?.responseEntity?.groups).toMutableList()
        )

    private fun getVenueListGroupResponse(groups: MutableList<VenueListGroupEntity>?): List<VenueListGroup> {
        return if (!groups.isNullOrEmpty()) groups.map { result ->
            VenueListGroup(
                items = getVenueListItemResponse(result.items).toMutableList()
            )
        } else mutableListOf(VenueListGroup())
    }

    private fun getVenueListItemResponse(items: MutableList<VenueListItemEntity>): List<VenueListItem> {
        return if (items.isNotEmpty()) items.map { result ->
            VenueListItem(
                venue = getVenueDetails(result.venue)
            )
        } else mutableListOf(VenueListItem())
    }

    private fun getVenueDetails(venueEntity: VenueEntity) = Venue(
        venueUniqId = venueEntity.venueUniqId,
        rating = venueEntity.rating.toFloat()/2,
        ratingColor = venueEntity.ratingColor,
        description = venueEntity.description.orEmpty().ifEmpty { "Not Available" },
        name = venueEntity.name,
        bestPhoto = getBestPhoto(bestPhotoEntity = venueEntity.bestPhotoEntity),
        contact = getContact(contactEntity = venueEntity.contactEntity),
        location = getLocation(locationEntity = venueEntity.locationEntity),
        photos = getPhotos(photosEntity = venueEntity.photosEntity)
    )


    private fun getLocation(locationEntity: LocationEntity) = Location(
        formattedAddress = locationEntity.formattedAddress
    )

    private fun getContact(contactEntity: ContactEntity) = Contact(
        facebook = contactEntity.facebook,
        facebookName = contactEntity.facebookName,
        facebookUsername = contactEntity.facebookUsername.orEmpty().ifEmpty { "Not Available" },
        formattedPhone = contactEntity.formattedPhone.orEmpty().ifEmpty { "Not Available" },
        instagram = contactEntity.instagram.orEmpty().ifEmpty { "Not Available" },
        phone = contactEntity.phone,
        twitter = contactEntity.twitter.orEmpty().ifEmpty { "Not Available" }
    )

    private fun getBestPhoto(bestPhotoEntity: BestPhotoEntity) = BestPhoto(
        createdAt = bestPhotoEntity.createdAt,
        height = bestPhotoEntity.height,
        prefix = bestPhotoEntity.prefix,
        suffix = bestPhotoEntity.suffix,
        visibility = bestPhotoEntity.visibility,
        width = bestPhotoEntity.width
    )

    private fun getPhotos(photosEntity: PhotosEntity) = Photos(
        count = photosEntity.count,
        groups = getPhotosGroups(photosEntity.groups).toMutableList()
    )

    private fun getPhotosGroups(groups: MutableList<PhotosGroupsEntity>): List<PhotosGroups> {
        return if (groups.isNotEmpty()) groups.map { result ->
            PhotosGroups(
                count = result.count,
                items = getPhotoGroupsItems(result.items).toMutableList()
            )
        } else mutableListOf(PhotosGroups())
    }

    private fun getPhotoGroupsItems(items: MutableList<PhotosGroupsItemsEntity>): List<PhotosGroupsItems> {
        return if (items.isNotEmpty()) items.map { result ->
            PhotosGroupsItems(
                width = result.width,
                height = result.height,
                prefix = result.prefix,
                suffix = result.suffix
            )
        } else mutableListOf(PhotosGroupsItems())
    }

    fun mapDataVenueDetailToDomainVenueDetail(venueDetailsEntity: retrofit2.Response<VenueDetailsEntity>?): retrofit2.Response<VenueDetails> {
        return retrofit2.Response.success(
            VenueDetails(
                response = getVenueDetailsResponseData(
                    venueDetailsEntity?.body()
                )
            )
        )
    }

    private fun getVenueDetailsResponseData(venueDetailsEntity: VenueDetailsEntity?) =
        VenueDetailsResponse(
            venue = getVenueDetails(venueDetailsEntity?.response?.venueEntity ?: VenueEntity())
        )


}