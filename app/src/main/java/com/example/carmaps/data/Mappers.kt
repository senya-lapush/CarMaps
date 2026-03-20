package com.example.carmaps.data

import com.example.carmaps.domain.Car
import com.example.carmaps.domain.Title

fun JsonItem.CarDto.toCar() = Car(
    parent = this.parent,
    type = this.type,
    title = this.title,
    lat = this.lat,
    lon = this.lon
)

fun JsonItem.TitleDto.toTitle() = Title(
    group = this.group,
    title = this.title
)