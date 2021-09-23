package com.example.shoppingappmvvm.data.api

import com.example.shoppingappmvvm.data.model.Product
import retrofit2.http.GET

interface APIService {
    @GET("products/")
    suspend fun callProducts(): List<Product>
}