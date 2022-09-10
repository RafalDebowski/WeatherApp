package debowski.rafal.weatherapp.data.dto

data class LocationDto(
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    val timezoneId: String,
    val localTime: String,
    val localTimeEpoch: Long,
    val utcOffset: String
) {
}