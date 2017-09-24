package com.denis.furaapp.presentation.presenter.map

import com.denis.furaapp.di.DI
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.denis.furaapp.presentation.view.map.MapView

@InjectViewState
class MapPresenter : MvpPresenter<MapView>() {

    init {
        DI.componentManager().appComponent().inject(this)
    }

}
