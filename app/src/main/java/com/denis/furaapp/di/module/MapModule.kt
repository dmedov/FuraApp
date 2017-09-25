package com.denis.furaapp.di.module

import com.denis.furaapp.model.IPlacesRepository
import com.denis.furaapp.model.PlacesRepository
import com.denis.furaapp.model.map.IMapInteractor
import com.denis.furaapp.model.map.MapInteractor
import com.denis.furaapp.model.map.api.PlacesApi
import com.denis.furaapp.model.map.persistance.*
import dagger.Module
import dagger.Provides

@Module
class MapModule {

    @Provides
    fun placesDao(placesDatabase: PlacesDatabase): IPlacesDao {
        return placesDatabase.placesDao()
    }

    @Provides
    fun placesStorage(placesDao: IPlacesDao, keyValueStorage: IKeyValueStorage): IPlacesStorage {
        return PlacesStorage(placesDao, keyValueStorage)
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