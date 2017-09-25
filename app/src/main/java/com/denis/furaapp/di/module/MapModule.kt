package com.denis.furaapp.di.module

import com.denis.furaapp.model.IPlacesRepository
import com.denis.furaapp.model.PlacesRepository
import com.denis.furaapp.model.map.IMapInteractor
import com.denis.furaapp.model.map.MapInteractor
import com.denis.furaapp.model.map.api.PlacesApi
import com.denis.furaapp.model.map.db.IPlacesStorage
import com.denis.furaapp.model.map.db.PlacesDao
import com.denis.furaapp.model.map.db.PlacesDatabase
import com.denis.furaapp.model.map.db.PlacesStorage
import dagger.Module
import dagger.Provides

@Module
class MapModule {

    @Provides
    fun placesDao(placesDatabase: PlacesDatabase): PlacesDao {
        return placesDatabase.placesDao()
    }

    @Provides
    fun placesStorage(placesDao: PlacesDao): IPlacesStorage {
        return PlacesStorage(placesDao)
    }

    @Provides
    fun placesRepository(placesApi: PlacesApi, placesStorage: IPlacesStorage): IPlacesRepository {
        return PlacesRepository(placesApi, placesStorage)
    }

    @Provides
    fun mapInteractor(placesRepository: IPlacesRepository): IMapInteractor {
        return MapInteractor(placesRepository)
    }
}