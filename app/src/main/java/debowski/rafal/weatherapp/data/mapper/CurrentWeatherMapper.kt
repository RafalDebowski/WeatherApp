package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.CurrentWeatherDomain
import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto

fun CurrentWeatherDto.toCurrentWeatherDomain(): CurrentWeatherDomain =
    CurrentWeatherDomain(
        requestDto = this.requestDto.toRequestDomain(),
        locationDto = this.locationDto.toLocationDomain(),
        currentDto = this.currentDto.toCurrentDomain()
    )

fun CurrentWeatherDomain.toCurrentWeatherDomain(): CurrentWeatherDto =
    CurrentWeatherDto(
        requestDto = this.requestDto.toRequestDto(),
        locationDto = this.locationDto.toLocationDto(),
        currentDto = this.currentDto.toCurrentDto()
    )