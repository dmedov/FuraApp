package com.denis.furaapp.presentation.presenter.map

import com.denis.furaapp.di.DI
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.denis.furaapp.model.map.IMapInteractor
import com.denis.furaapp.presentation.view.map.MapView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MapPresenter : MvpPresenter<MapView>() {

    @Inject
    lateinit var mapInteractor: IMapInteractor

    init {
        DI.componentManager().appComponent().inject(this)
    }

    override fun onFirstViewAttach() {
        synMapData()

        mapInteractor.observePlaces()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showPlaces(it)
                }, {
                    Timber.e(it)
                })
    }

    private fun synMapData() {
        mapInteractor.syncMapData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.i("places downloaded")
                    viewState.showLoadingFinished()
                }, {
                    Timber.e(it)
                })
    }

}
