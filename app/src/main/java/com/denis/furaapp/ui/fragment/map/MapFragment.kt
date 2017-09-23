package com.denis.furaapp.ui.fragment.map

import com.denis.furaapp.R
import com.denis.furaapp.presentation.view.map.MapView
import com.denis.furaapp.presentation.presenter.map.MapPresenter

import com.arellomobile.mvp.presenter.InjectPresenter

class MapFragment : BaseMapFragment(), MapView {

    companion object {
        fun newInstance() = MapFragment()
    }

    @InjectPresenter
    lateinit var presenter: MapPresenter

    override val fragmentLayout: Int
        get() = R.layout.fragment_map
}
