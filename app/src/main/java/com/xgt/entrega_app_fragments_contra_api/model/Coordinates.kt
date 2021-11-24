package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Coordinates(
    @SerializedName("latitude")
    @Expose
    val latitude: String,
    @SerializedName("longitude")
    @Expose
    val longitude: String
)