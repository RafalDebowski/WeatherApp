package debowski.rafal.weatherapp.data.domain



data class CurrentWeatherDomain(
    val requestDto: RequestDomain,
    val locationDto: LocationDomain,
    val currentDto: CurrentDomain
)