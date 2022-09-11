package debowski.rafal.weatherapp.data.domain

data class CurrentDomain(
    val id: Long? = null,
    var currentWeatherId: Long? = null,
    val observationTime: String,
    val temperature: Int,
    val weatherCode: Int,
    val weatherIcons: Array<String>?,
    val weatherDescriptions: Array<String>?,
    val windSpeed: Int,
    val windDegree: Int,
    val windDir: String,
    val pressure : Int,
    val humidity: Int,
    val cloudCover: Int,
    val feelsLike: Int,
    val uvIndex: Int,
    val visibility: Int
) {
}