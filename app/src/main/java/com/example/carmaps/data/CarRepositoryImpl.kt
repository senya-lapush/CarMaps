package com.example.carmaps.data

import com.example.carmaps.domain.Car
import com.example.carmaps.domain.CarRepository
import com.example.carmaps.domain.Title
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarRepositoryImpl(
    private val carService: CarService
) : CarRepository {
    override suspend fun getCarTitlesAndGroups(): Map<Title, List<Car>> =
        withContext(Dispatchers.IO) {
            val items = carService.getCarTitlesAndGroupsFromAssets()

            val titles = items.filterIsInstance<JsonItem.TitleDto>().map { it.toTitle() }
            val cars = items.filterIsInstance<JsonItem.CarDto>().map { it.toCar() }

            val groupedCars = cars.groupBy { it.parent }

            titles.associateWith { title ->
                groupedCars[title.group] ?: emptyList()
            }
        }
}