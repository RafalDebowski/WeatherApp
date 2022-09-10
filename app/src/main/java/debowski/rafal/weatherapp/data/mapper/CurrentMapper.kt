package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.CurrentDomain
import debowski.rafal.weatherapp.data.dto.CurrentDto

fun CurrentDto.toCurrentDomain(): CurrentDomain =
    CurrentDomain(
        observationTime = this.observationTime,
        temperature = this.temperature,
        weatherCode = this.weatherCode,
        weatherIcons = this.weatherIcons,
        weatherDescription = this.weatherDescription,
        windSpeed = this.windSpeed,
        windDegree = this.windDegree,
        windDir = this.windDir,
        pressure = this.pressure,
        precip = this.precip,
        humidity = this.humidity,
        cloudCover = this.cloudCover,
        feelsLike = this.feelsLike,
        uvIndex = this.uvIndex,
        visibility = this.visibility
    )

fun CurrentDomain.toCurrentDto(): CurrentDto =
    CurrentDto(
        observationTime = this.observationTime,
        temperature = this.temperature,
        weatherCode = this.weatherCode,
        weatherIcons = this.weatherIcons,
        weatherDescription = this.weatherDescription,
        windSpeed = this.windSpeed,
        windDegree = this.windDegree,
        windDir = this.windDir,
        pressure = this.pressure,
        precip = this.precip,
        humidity = this.humidity,
        cloudCover = this.cloudCover,
        feelsLike = this.feelsLike,
        uvIndex = this.uvIndex,
        visibility = this.visibility
    )