package com.example.carmaps.di

import com.example.carmaps.data.CarRepositoryImpl
import com.example.carmaps.data.CarService
import com.example.carmaps.domain.CarRepository
import com.example.carmaps.presentation.catalog.CatalogViewModel
import com.example.carmaps.presentation.map.MapViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::CarService)
    singleOf(::CarRepositoryImpl) bind(CarRepository::class)
    viewModelOf(::CatalogViewModel)
    viewModel {
        MapViewModel(
            savedStateHandle = get()
        )
    }
}