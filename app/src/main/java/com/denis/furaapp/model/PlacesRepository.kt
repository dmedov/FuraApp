package com.denis.furaapp.model

import com.denis.furaapp.model.map.api.PlacesApi
import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Single

class PlacesRepository(private val placesApi: PlacesApi) : IPlacesRepository {
    override fun downloadPlaces(startId: Int): Single<PlacesResponse> {
        return placesApi.places(startId, 300)
    }

    override fun latestPlaceId(): Single<Int> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isDownloadComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}