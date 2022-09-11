package debowski.rafal.weatherapp.data.dto

import androidx.annotation.Keep

@Keep
data class CurrentWeatherDto(
    val id: Long?,
    val request: RequestDto?,
    val location: LocationDto?,
    val current: CurrentDto?
)