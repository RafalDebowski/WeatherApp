package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.CurrentWeatherDomain
import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto
import debowski.rafal.weatherapp.data.entity.CurrentWeatherEntity

fun CurrentWeatherDto.toCurrentWeatherDomain(): CurrentWeatherDomain =
    CurrentWeatherDomain(
        id = this.id ?: -1,
        request = this.request?.toRequestDomain(),
        location = this.location?.toLocationDomain(),
        current = this.current?.toCurrentDomain()
    )

fun CurrentWeatherDomain.toCurrentWeatherDto(): CurrentWeatherDto =
    CurrentWeatherDto(
        id = this.id,
        request = this.request?.toRequestDto(),
        location = this.location?.toLocationDto(),
        current = this.current?.toCurrentDto()
    )


fun CurrentWeatherDomain.toCurrentWeatherEntity(): CurrentWeatherEntity =
    CurrentWeatherEntity(
        request = this.request?.toRequestEntity(),
        location = this.location?.toLocationEntity(),
        current = this.current?.toCurrentEntity()
    )

fun CurrentWeatherEntity.toCurrentWeatherDomain(): CurrentWeatherDomain =
    CurrentWeatherDomain(
        id = this.id ?: -1,
        request = this.request?.toRequestDomain(),
        location = this.location?.toLocationDomain(),
        current = this.current?.toCurrentDomain()
    )