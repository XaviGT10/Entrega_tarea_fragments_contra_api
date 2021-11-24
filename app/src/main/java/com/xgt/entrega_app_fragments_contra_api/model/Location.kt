package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Location(
    @SerializedName("city")
    @Expose
    val city: String,
    @SerializedName("coordinates")
    @Expose
    val coordinates: Coordinates,
    @SerializedName("country")
    @Expose
    val country: String,
    @SerializedName("postcode")
    @Expose
    val postcode: String,
    @SerializedName("state")
    @Expose
    val state: String,
    @SerializedName("street")
    @Expose
    val street: Street,
    @SerializedName("timezone")
    @Expose
    val timezone: Timezone
)