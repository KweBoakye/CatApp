package com.kweku.catapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Breeds(
    val id : String,
    val name: String,
    val temperament: String,
    val lifeSpan: String,
    val altNames: String,
    val wikipediaUrl: String,
    val origin: String,
    val weightImperial: String,
    val experimental : Boolean,
    val hairless : Boolean,
    val natural: Boolean,
    val rare: Boolean,
    val suppressTail: Boolean,
    val rex: Boolean,
    val shortLegs: Boolean,
    val hypoallergenic: Boolean,
    val adaptability: Int,
    val affectionLevel: Int,
    val countryCode: String,
    val childFriendly: Int,
    val dogFriendly: Int,
    val energyLevel: Int,
    val grooming: Int,
    val healthIssues: Int,
    val intelligence: Int,
    val sheddingLevel: Int,
    val socialNeeds: Int,
    val strangerFriendly: Int,
    val vocalisation: Int

)
