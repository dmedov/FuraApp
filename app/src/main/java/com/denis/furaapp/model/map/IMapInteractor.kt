package com.denis.furaapp.model.map

import io.reactivex.Completable

interface IMapInteractor {
    fun downloadPlaces(): Completable
}