package debowski.rafal.weatherapp.data.domain

data class RequestDomain(
    val id : Long? = null,
    var currentWeatherId: Long? = null,
    val type: String,
    val query: String,
    val language: String,
    val unit: String
) {
}