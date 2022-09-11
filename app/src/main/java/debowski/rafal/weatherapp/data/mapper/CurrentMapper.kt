package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.CurrentDomain
import debowski.rafal.weatherapp.data.dto.CurrentDto
import debowski.rafal.weatherapp.data.entity.CurrentEntity

fun CurrentDto.toCurrentDomain(): CurrentDomain =
    CurrentDomain(
        observationTime = this.observation_time.orEmpty(),
        temperature = this.temperature ?: -1,
        weatherCode = this.weather_code ?: -1,
        weatherIcons = this.weather_icons,
        weatherDescriptions = this.weather_descriptions,
        windSpeed = this.wind_speed ?: -1,
        windDegree = this.wind_degree ?: -1,
        windDir = this.wind_dir.orEmpty(),
        pressure = this.pressure ?: -1,
        humidity = this.humidity ?: -1,
        cloudCover = this.cloudCover ?: -1,
        feelsLike = this.feelslike ?: -1,
        uvIndex = this.uvIndex ?: -1,
        visibility = this.visibility ?: -1
    )

fun CurrentDomain.toCurrentDto(): CurrentDto =
    CurrentDto(
        observation_time = this.observationTime,
        temperature = this.temperature,
        weather_code = this.weatherCode,
        weather_icons = this.weatherIcons,
        weather_descriptions = this.weatherDescriptions,
        wind_speed = this.windSpeed,
        wind_degree = this.windDegree,
        wind_dir = this.windDir,
        pressure = this.pressure,
        humidity = this.humidity,
        cloudCover = this.cloudCover,
        feelslike = this.feelsLike,
        uvIndex = this.uvIndex,
        visibility = this.visibility
    )

fun CurrentDomain.toCurrentEntity(): CurrentEntity =
    CurrentEntity(
        currentWeatherId = this.currentWeatherId,
        observationTime = this.observationTime,
        temperature = this.temperature,
        weatherCode = this.weatherCode,
        weatherIcons = this.weatherIcons,
        weatherDescriptions = this.weatherDescriptions,
        windSpeed = this.windSpeed,
        windDegree = this.windDegree,
        windDir = this.windDir,
        pressure = this.pressure,
        humidity = this.humidity,
        cloudCover = this.cloudCover,
        feelsLike = this.feelsLike,
        uvIndex = this.uvIndex,
        visibility = this.visibility
    )

fun CurrentEntity.toCurrentDomain(): CurrentDomain =
    CurrentDomain(
        id = this.id,
        observationTime = this.observationTime,
        temperature = this.temperature,
        weatherCode = this.weatherCode,
        weatherIcons = this.weatherIcons,
        weatherDescriptions = this.weatherDescriptions,
        windSpeed = this.windSpeed,
        windDegree = this.windDegree,
        windDir = this.windDir,
        pressure = this.pressure,
        humidity = this.humidity,
        cloudCover = this.cloudCover,
        feelsLike = this.feelsLike,
        uvIndex = this.uvIndex,
        visibility = this.visibility
    )
