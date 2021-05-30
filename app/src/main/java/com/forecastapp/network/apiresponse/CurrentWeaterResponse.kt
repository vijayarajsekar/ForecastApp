package com.forecastapp.network.apiresponse

import com.forecastapp.data.db.entity.Request
import com.forecastapp.data.db.entity.CurrentWeather
import com.forecastapp.data.db.entity.Location


data class CurrentWeaterResponse(
    val request: Request,
    val location: Location,
    val current: CurrentWeather
)