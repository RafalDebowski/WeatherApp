package debowski.rafal.weatherapp.data.domain

data class LocationDomain(
    val id: Long? = null,
    var currentWeatherId: Long? = null,
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    val timezoneId: String,
    val localTime: String,
    val localTimeEpoch: String,
    val utcOffset: String
)