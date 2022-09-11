package debowski.rafal.weatherapp.data.domain

data class CurrentWeatherDomain(
    val id: Long,
    val request: RequestDomain?,
    val location: LocationDomain?,
    val current: CurrentDomain?
)