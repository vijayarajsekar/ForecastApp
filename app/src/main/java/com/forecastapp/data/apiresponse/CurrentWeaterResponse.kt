package com.forecastapp.data.apiresponse


data class CurrentWeaterResponse(
    val request: Request,
    val location: Location,
    val current: CurrentWeather
)