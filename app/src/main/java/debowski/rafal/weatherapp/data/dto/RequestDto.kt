package debowski.rafal.weatherapp.data.dto

data class RequestDto(
    val type: String,
    val query: String,
    val language: String,
    val unit: String
)