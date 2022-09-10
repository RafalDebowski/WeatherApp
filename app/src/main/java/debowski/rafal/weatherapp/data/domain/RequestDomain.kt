package debowski.rafal.weatherapp.data.domain

data class RequestDomain(
    val type: String,
    val query: String,
    val language: String,
    val unit: String
) {
}