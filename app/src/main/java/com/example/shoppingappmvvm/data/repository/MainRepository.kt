package com.example.shoppingappmvvm.data.repository

import com.example.shoppingappmvvm.data.api.APIService
import com.example.shoppingappmvvm.data.model.Product
import com.example.shoppingappmvvm.networking.Retrofit

class MainRepository {

    suspend fun getProducts(): List<Product> {
        return Retrofit.getRetrofit().create(APIService::class.java).callProducts()
    }
}