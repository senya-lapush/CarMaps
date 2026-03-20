package com.example.carmaps.presentation.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carmaps.R
import com.example.carmaps.domain.Car
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatalogScreen(
    viewModel: CatalogViewModel = koinViewModel<CatalogViewModel>(),
    onItemClicked: (String, String) -> Unit
) {
    val isExpandedMap = remember { mutableStateMapOf<String, Boolean>() }

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            viewModel.state.cars.forEach { (title, cars) ->
                carSection(
                    title = title.title,
                    cars = cars,
                    isExpanded = isExpandedMap[title.title] ?: true,
                    onTitleClicked = {
                        isExpandedMap[title.title] = !(isExpandedMap[title.title] ?: true)
                    },
                    onItemClicked = onItemClicked
                )
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

fun LazyListScope.carSection(
    title: String,
    cars: List<Car>,
    isExpanded: Boolean,
    onTitleClicked: () -> Unit,
    onItemClicked: (String, String) -> Unit
) {
    item {
        Title(
            text = title,
            isExpanded = isExpanded,
            onClick = { onTitleClicked() }
        )
    }

    if (isExpanded) {
        items(cars) { car ->
            Car(
                title = stringResource(R.string.car_title, car.title, car.type),
                onClick = { onItemClicked(car.lat.toString(), car.lon.toString()) }
            )
        }
    }
}

@Composable
fun Title(text: String, isExpanded: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan.copy(0.5f))
            .clickable { onClick() }
            .padding(vertical = 10.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        if (isExpanded) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowUp,
                contentDescription = null,
                tint = Color.Black
            )
        } else {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun Car(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(1.dp, Color.LightGray)
            .clickable { onClick() }
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}