package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Info(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("results")
    @Expose
    val results: Int,
    @SerializedName("seed")
    @Expose
    val seed: String,
    @SerializedName("version")
    @Expose
    val version: String
)