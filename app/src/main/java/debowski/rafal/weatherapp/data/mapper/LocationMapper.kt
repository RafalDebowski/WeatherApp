package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.LocationDomain
import debowski.rafal.weatherapp.data.dto.LocationDto
import debowski.rafal.weatherapp.data.entity.LocationEntity

fun LocationDto.toLocationDomain(): LocationDomain =
    LocationDomain(
        name = this.name.orEmpty(),
        country = this.country.orEmpty(),
        region = this.region.orEmpty(),
        lat = this.lat.orEmpty(),
        lon = this.lon.orEmpty(),
        timezoneId = this.timezone_id.orEmpty(),
        localTime = this.localtime.orEmpty(),
        localTimeEpoch = this.localtime_epoch.orEmpty(),
        utcOffset = this.utc_offset.orEmpty()
    )

fun LocationDomain.toLocationDto(): LocationDto =
    LocationDto(
        name = this.name,
        country = this.country,
        region = this.region,
        lat = this.lat,
        lon = this.lon,
        timezone_id = this.timezoneId,
        localtime = this.localTime,
        localtime_epoch = this.localTimeEpoch,
        utc_offset = this.utcOffset
    )

fun LocationDomain.toLocationEntity(): LocationEntity =
    LocationEntity(
        currentWeatherId = this.currentWeatherId,
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

fun LocationEntity.toLocationDomain(): LocationDomain =
    LocationDomain(
        id = this.id,
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