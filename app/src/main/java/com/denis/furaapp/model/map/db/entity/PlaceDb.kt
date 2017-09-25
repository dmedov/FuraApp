package com.denis.furaapp.model.map.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "places")
class PlaceDb constructor(@PrimaryKey @ColumnInfo(name = "id") var id: Int = 1,
                          @ColumnInfo(name = "name") var name: String? = "",
                          @ColumnInfo(name = "lat") var lat: Float = 0.0f,
                          @ColumnInfo(name = "lng") var lng: Float = 0.0f,
                          @ColumnInfo(name = "category_id") var categoryId: Int? = null)