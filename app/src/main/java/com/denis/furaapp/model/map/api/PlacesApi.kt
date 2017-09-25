package com.denis.furaapp.model.map.api

import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlacesApi {

    @GET("places")
    fun places(@Query("startFrom") startFrom: Int,
               @Query("pageSize") pageSize: Int): Observable<PlacesResponse>
}