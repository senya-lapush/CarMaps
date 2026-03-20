package com.example.carmaps.presentation.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.carmaps.presentation.navigation.Screen

class MapViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(MapState())
        private set

    init {
        val lat = savedStateHandle.get<String>(Screen.lat)?.toDoubleOrNull()
        val lon = savedStateHandle.get<String>(Screen.lon)?.toDoubleOrNull()

        if (lat != null && lon != null) {
            state = state.copy(
                lat = lat,
                lon = lon
            )
        }
    }
}