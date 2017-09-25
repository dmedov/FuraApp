package com.denis.furaapp.di.module

import com.denis.furaapp.model.IPlacesRepository
import com.denis.furaapp.model.PlacesRepository
import com.denis.furaapp.model.map.IMapInteractor
import com.denis.furaapp.model.map.MapInteractor
import com.denis.furaapp.model.map.api.PlacesApi
import dagger.Module
import dagger.Provides

@Module
class MapModule {

    @Provides
    fun placesRepository(placesApi: PlacesApi): IPlacesRepository {
        return PlacesRepository(placesApi)
    }

    @Provides
    fun mapInteractor(placesRepository: IPlacesRepository): IMapInteractor {
        return MapInteractor(placesRepository)
    }
}