package com.denis.furaapp

import android.support.v4.app.FragmentActivity
import android.os.Bundle

import com.denis.furaapp.ui.fragment.map.MapFragment

class MapActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        addMapFragment()
    }

    private fun addMapFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_map, MapFragment.newInstance())
                .commit()
    }
}
