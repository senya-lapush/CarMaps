package com.example.carmaps.presentation.catalog

import com.example.carmaps.domain.Car
import com.example.carmaps.domain.Title

data class CatalogState(
    val cars: Map<Title, List<Car>> = emptyMap()
)
