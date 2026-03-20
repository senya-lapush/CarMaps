package com.example.carmaps.presentation.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.carmaps.MapComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun MapScreen(
    viewModel: MapViewModel = koinViewModel<MapViewModel>()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPaddings ->
        MapComponent(
            paddings = innerPaddings,
            lat = viewModel.state.lat,
            lon = viewModel.state.lon
        )
    }
}