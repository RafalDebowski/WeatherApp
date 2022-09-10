package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.LocationDomain
import debowski.rafal.weatherapp.data.dto.LocationDto

fun LocationDto.toLocationDomain(): LocationDomain =
    LocationDomain(
        name = this.name,
        country = this.country,
        region = this.region,
        lat = this.lat,
        lon = this.lon,
        timezoneId = this.timezoneId,
        localTime = this.localTime,
        localTimeEpoch = this.localTimeEpoch,
        utcOffset = this.utcOffset
    )

fun LocationDomain.toLocationDto(): LocationDto =
    LocationDto(
        name = this.name,
        country = this.country,
        region = this.region,
        lat = this.lat,
        lon = this.lon,
        timezoneId = this.timezoneId,
        localTime = this.localTime,
        localTimeEpoch = this.localTimeEpoch,
        utcOffset = this.utcOffset
    )