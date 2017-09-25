package com.denis.furaapp.model.map

import com.denis.furaapp.model.IPlacesRepository
import com.denis.furaapp.model.map.api.PlacesApi
import com.denis.furaapp.model.map.entity.Place
import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapInteractorTest {

    lateinit var interactor: IMapInteractor

    @Mock
    lateinit var repository: IPlacesRepository

    @Before
    fun setUp() {
        interactor = MapInteractor(repository)
    }

    @Test
    fun syncMapDataCompletes() {
        setUpRepository()

        val testObserver = interactor.syncMapData().test()

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        verify(repository, times(1)).persistPlaces(ArgumentMatchers.anyList())
        verify(repository, times(2)).fetchPlaces(ArgumentMatchers.anyInt())
    }

    private fun setUpRepository() {
        `when`(repository.fetchPlaces(1)).thenReturn(
                Observable.just(PlacesResponse(arrayListOf(Place(1, "test", 10.1f, 10.2f, "1")),
                        true))
        )

        `when`(repository.fetchPlaces(2)).thenReturn(
                Observable.just(PlacesResponse(arrayListOf(),
                        false))
        )

        `when`(repository.setLatestPlaceId(ArgumentMatchers.anyInt()))
                .thenReturn(Completable.complete())

        `when`(repository.latestPlaceId())
                .thenReturn(Single.fromCallable { 1 })
                .thenReturn(Single.fromCallable { 2 })

        `when`(repository.persistPlaces(ArgumentMatchers.anyList()))
                .thenReturn(Completable.complete())
    }

}