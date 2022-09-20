package com.kweku.catapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageModel(
    val id: String,
    val url: String,
    val categories: List<Category>,
    val breeds: List<Breeds>
)
