package debowski.rafal.weatherapp.data.domain

data class Weather(
    val name: String?,
    val localTime: String?,
    val observationTime: String?,
    val temperature: Int?,
    val weatherIcons: Array<String>?,
    val weatherDescriptions: Array<String>?,
    val feelsLike: Int
)