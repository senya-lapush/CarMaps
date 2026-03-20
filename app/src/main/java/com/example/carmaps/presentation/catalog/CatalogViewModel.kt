package com.example.carmaps.presentation.catalog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carmaps.domain.CarRepository
import kotlinx.coroutines.launch

class CatalogViewModel(
    private val repository: CarRepository
) : ViewModel() {

    var state by mutableStateOf(CatalogState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                cars = repository.getCarTitlesAndGroups()
            )
        }
    }
}