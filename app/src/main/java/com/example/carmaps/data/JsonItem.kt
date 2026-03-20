package com.example.carmaps.data

import kotlinx.serialization.Serializable

@Serializable(CarSerializer::class)
sealed class JsonItem {
    abstract val parent: String
    abstract val title: String

    @Serializable
    data class CarDto(
        override val parent: String,
        override val title: String,
        val type: String,
        val lat: Double,
        val lon: Double
    ) : JsonItem()

    @Serializable
    data class TitleDto(
        override val parent: String,
        override val title: String,
        val group: String
    ) : JsonItem()
}