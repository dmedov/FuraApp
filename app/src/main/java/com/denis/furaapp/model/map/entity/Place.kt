package com.denis.furaapp.model.map.entity

import com.google.gson.annotations.SerializedName

data class Place(@SerializedName("id") val id: Int,
                 @SerializedName("name") val name: String?,
                 @SerializedName("lat") val lat: Float,
                 @SerializedName("lng") val lng: Float,
                 @SerializedName("categoryId") val categoryId: Int?)