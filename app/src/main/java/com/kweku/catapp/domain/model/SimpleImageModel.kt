package com.kweku.catapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SimpleImageModel(
    val breeds: List<Breeds>,
    val categories: List<Category>,
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)
