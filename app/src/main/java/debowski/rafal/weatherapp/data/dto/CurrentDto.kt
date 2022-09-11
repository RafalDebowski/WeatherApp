package debowski.rafal.weatherapp.data.dto

import androidx.annotation.Keep

@Keep
data class CurrentDto(
    val observation_time: String?,
    val temperature: Int?,
    val weather_code: Int?,
    val weather_icons: Array<String>?,
    val weather_descriptions: Array<String>?,
    val wind_speed: Int?,
    val wind_degree: Int?,
    val wind_dir: String?,
    val pressure: Int?,
    val humidity: Int?,
    val feelslike: Int?,
    val cloudCover: Int?,
    val uvIndex: Int?,
    val visibility: Int?
) {
}