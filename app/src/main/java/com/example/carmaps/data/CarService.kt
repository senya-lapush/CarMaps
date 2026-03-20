package com.example.carmaps.data

import android.content.Context
import kotlinx.serialization.json.Json

class CarService(
    private val context: Context
) {
    fun getCarTitlesAndGroupsFromAssets(): List<JsonItem> {
        val jsonString = context.assets.open(JSON_FILE_NAME).bufferedReader().use { it.readText() }

        return try {
            Json.decodeFromString<JsonWrapper>(jsonString).cars.list
        } catch (e: Exception) {
            emptyList()
        }
    }

    companion object {
        private const val JSON_FILE_NAME = "cars.json"
    }
}