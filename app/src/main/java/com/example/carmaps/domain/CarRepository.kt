package com.example.carmaps.domain

interface CarRepository {
    suspend fun getCarTitlesAndGroups(): Map<Title, List<Car>>
}