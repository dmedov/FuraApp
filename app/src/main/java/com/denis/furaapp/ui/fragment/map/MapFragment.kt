package com.denis.furaapp.ui.fragment.map

import com.denis.furaapp.R
import com.denis.furaapp.presentation.view.map.MapView
import com.denis.furaapp.presentation.presenter.map.MapPresenter

import com.arellomobile.mvp.presenter.InjectPresenter
import com.denis.furaapp.model.map.entity.Place
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions



class MapFragment : BaseMapFragment(), MapView {

    private lateinit var googleMap: GoogleMap

    companion object {
        fun newInstance() = MapFragment()
    }

    @InjectPresenter
    lateinit var presenter: MapPresenter

    override val fragmentLayout: Int
        get() = R.layout.fragment_map

    override fun showPlaces(places: List<Place>) {
        places.forEach { place ->
            val position = LatLng(place.lat.toDouble(), place.lng.toDouble())
            val marker = MarkerOptions().position(position)
            googleMap.addMarker(marker)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        super.onMapReady(googleMap)
        this.googleMap = googleMap
    }

    override fun showLoadingFinished() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
