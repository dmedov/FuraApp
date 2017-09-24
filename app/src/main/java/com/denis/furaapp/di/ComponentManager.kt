package com.denis.furaapp.di

import com.denis.furaapp.di.component.AppComponent
import com.denis.furaapp.di.module.AppModule
import android.content.Context
import com.denis.furaapp.di.component.DaggerAppComponent

class ComponentManager(val context: Context) {

    val internalAppComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                          .appModule(AppModule()).build()
    }

    fun appComponent() = internalAppComponent
}