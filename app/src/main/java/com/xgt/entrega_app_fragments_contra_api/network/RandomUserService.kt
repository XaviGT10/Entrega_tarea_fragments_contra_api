package com.xgt.entrega_app_fragments_contra_api.network

import com.xgt.entrega_app_fragments_contra_api.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserService {
    @GET("?results=50")
    fun getUsers(): Call<UserResponse>
}