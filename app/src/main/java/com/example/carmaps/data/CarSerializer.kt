package com.example.carmaps.data

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

object CarSerializer : JsonContentPolymorphicSerializer<JsonItem>(JsonItem::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<JsonItem> {
        val jsonObject = element.jsonObject

        return when {
            jsonObject.containsKey("group") -> JsonItem.TitleDto.serializer()
            jsonObject.containsKey("type") -> JsonItem.CarDto.serializer()
            else -> throw SerializationException("Unknown Json Object")
        }
    }
}