package com.example.shoppingappmvvm.data.model

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Product (
    val id: Int,
    val title: String,
    val description: String,
    val image: String
): Serializable