package com.denis.furaapp.model.map.entity

import com.google.gson.annotations.SerializedName

data class PlacesResponse(@SerializedName("data") val places: List<Place>,
                          @SerializedName("hasMorePages") val hasMorePages: Boolean)