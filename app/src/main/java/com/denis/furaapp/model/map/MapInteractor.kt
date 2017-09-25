package com.denis.furaapp.model.map

import com.denis.furaapp.model.IPlacesRepository
import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Completable

class MapInteractor(private val placesRepository: IPlacesRepository) : IMapInteractor {
    override fun syncMapData(): Completable {
        return downloadPlaces()
    }

    private fun downloadPlaces(): Completable {
        return placesRepository.latestPlaceId()
                .flatMapObservable { placesRepository.fetchPlaces(it) }
                .doOnNext { persistPlaces(it) }
                .doOnNext { saveLatestId(it) }
                .flatMapCompletable {
                    if (it.hasMorePages) {
                        downloadPlaces()
                    } else {
                        Completable.complete()
                    }
                }
    }

    private fun persistPlaces(it: PlacesResponse) {
        if (it.places.isEmpty()) {
            return
        }

        placesRepository.persistPlaces(it.places)
                        .subscribe()
    }

    private fun saveLatestId(it: PlacesResponse) {
        if (it.places.isEmpty()) {
            return
        }

        placesRepository.setLatestPlaceId(it.places.maxBy { it.id }?.id ?: 1)
                        .subscribe()
    }
}