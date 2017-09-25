package com.denis.furaapp.model.map

import com.denis.furaapp.model.IPlacesRepository
import io.reactivex.Completable

class MapInteractor(private val placesRepository: IPlacesRepository) : IMapInteractor {
    override fun downloadPlaces(): Completable {
        return placesRepository.downloadPlaces(1).toCompletable()
    }
}