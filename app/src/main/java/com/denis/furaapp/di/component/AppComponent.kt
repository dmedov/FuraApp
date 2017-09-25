package com.denis.furaapp.di.component

import com.denis.furaapp.di.module.AppModule
import com.denis.furaapp.di.module.MapModule
import com.denis.furaapp.di.module.NetworkModule
import com.denis.furaapp.presentation.presenter.map.MapPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, MapModule::class))
interface AppComponent {
    fun inject(presenter: MapPresenter)
}