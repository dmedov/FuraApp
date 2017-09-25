package com.denis.furaapp.presentation.view.map

import com.arellomobile.mvp.MvpView
import com.denis.furaapp.model.map.entity.Place

interface MapView : MvpView {
    fun showPlaces(places: List<Place>)
    fun showLoadingFinished()
}
