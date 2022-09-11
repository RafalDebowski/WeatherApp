package debowski.rafal.weatherapp.data.dto

import androidx.annotation.Keep

@Keep
data class RequestDto(
    val type: String?,
    val query: String?,
    val language: String?,
    val unit: String?
)