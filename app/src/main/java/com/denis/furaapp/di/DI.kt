package com.denis.furaapp.di

import android.content.Context
import com.denis.furaapp.di.ComponentManager

object DI {

    private lateinit var componentManager: ComponentManager

    fun init(context: Context) {
        componentManager = ComponentManager(context)
    }

    fun componentManager(): ComponentManager = componentManager
}