package debowski.rafal.weatherapp.data.dto

import androidx.annotation.Keep

@Keep
data class CurrentDto(
    val observationTime: String,
    val temperature: Long,
    val weatherCode: Long,
    val weatherIcons: String,
    val weatherDescription: String,
    val windSpeed: Long,
    val windDegree: Long,
    val windDir: String,
    val pressure : Long,
    val precip: Long,
    val humidity: Long,
    val cloudCover: Long,
    val feelsLike: Long,
    val uvIndex: Long,
    val visibility: Long
) {
}