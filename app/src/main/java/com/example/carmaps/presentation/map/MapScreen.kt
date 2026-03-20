package com.example.carmaps.presentation.map

import androidx.compose.runtime.Composable
import com.example.carmaps.MapComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun MapScreen(
    viewModel: MapViewModel = koinViewModel<MapViewModel>()
) {
    MapComponent(viewModel.state.lat, viewModel.state.lon)
}