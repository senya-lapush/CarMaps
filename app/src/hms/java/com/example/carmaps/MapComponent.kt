package com.example.carmaps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.GestureOptions
import org.maplibre.compose.map.MapOptions
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.map.OrnamentOptions
import org.maplibre.compose.style.BaseStyle
import org.maplibre.spatialk.geojson.Position

@Composable
fun MapComponent(
    paddings: PaddingValues,
    lat: Double,
    lon: Double
) {
    val cameraState = rememberCameraState(
        firstPosition = CameraPosition(
            target = Position(lon, lat),
            zoom = 14.0
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddings)
    ) {

        MaplibreMap(
            modifier = Modifier.fillMaxSize(),
            baseStyle = BaseStyle.Uri("https://maps.starline.ru/mapstyles/default/style.json"),
            cameraState = cameraState,
            options = MapOptions(
                ornamentOptions = OrnamentOptions.AllDisabled,
                gestureOptions = GestureOptions.AllDisabled
            ),
        )

        //maplibre compose пока не поддерживает маркеры
        //камера по полученным координатам позиционируется посередине, поэтому "маркер" ставится
        //по центру со сдвигом по y из-за высоты иконки
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center)
                .graphicsLayer {
                    translationY = -size.height / 2f
                },
            imageVector = Icons.Filled.LocationOn,
            tint = Color.Red,
            contentDescription = null
        )
    }
}