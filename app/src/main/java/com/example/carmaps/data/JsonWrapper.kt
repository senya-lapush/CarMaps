package com.example.carmaps.data

import kotlinx.serialization.Serializable

@Serializable
data class JsonWrapper(
    val cars: ListContainer
)

@Serializable
data class ListContainer(
    val list: List<JsonItem>
)