package debowski.rafal.weatherapp.data.dto

data class CurrentWeatherDto(
    val requestDto: RequestDto,
    val locationDto: LocationDto,
    val currentDto: CurrentDto
) {
}