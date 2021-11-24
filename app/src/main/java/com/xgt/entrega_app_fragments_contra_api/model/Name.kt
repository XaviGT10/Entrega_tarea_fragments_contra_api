package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Name(
    @SerializedName("first")
    @Expose
    val first: String,
    @SerializedName("last")
    @Expose
    val last: String,
    @SerializedName("title")
    @Expose
    val title: String
)