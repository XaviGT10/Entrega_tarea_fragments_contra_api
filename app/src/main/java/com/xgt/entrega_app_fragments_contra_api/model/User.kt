package com.xgt.entrega_app_fragments_contra_api.model


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class User(
    @SerializedName("cell")
    @Expose
    val cell: String,
    @SerializedName("dob")
    @Expose
    val dob: Dob,
    @SerializedName("email")
    @Expose
    val email: String,
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("id")
    @Expose
    val id: Id,
    @SerializedName("location")
    @Expose
    val location: Location,
    @SerializedName("login")
    @Expose
    val login: Login,
    @SerializedName("name")
    @Expose
    val name: Name,
    @SerializedName("nat")
    @Expose
    val nat: String,
    @SerializedName("phone")
    @Expose
    val phone: String,
    @SerializedName("picture")
    @Expose
    val picture: Picture,
    @SerializedName("registered")
    @Expose
    val registered: Registered
)