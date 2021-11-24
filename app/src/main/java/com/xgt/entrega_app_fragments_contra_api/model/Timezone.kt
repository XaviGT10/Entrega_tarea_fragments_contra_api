package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Timezone(
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("offset")
    @Expose
    val offset: String
)