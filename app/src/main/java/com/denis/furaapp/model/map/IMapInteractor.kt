package com.denis.furaapp.model.map

import com.denis.furaapp.model.map.entity.Place
import io.reactivex.Completable
import io.reactivex.Flowable

interface IMapInteractor {
    fun syncMapData(): Completable
    fun observePlaces(): Flowable<List<Place>>
}