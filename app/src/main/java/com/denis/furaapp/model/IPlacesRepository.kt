package com.denis.furaapp.model

import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Single

interface IPlacesRepository {
    fun downloadPlaces(startId: Int): Single<PlacesResponse>
    fun latestPlaceId(): Single<Int>
    fun isDownloadComplete()
}