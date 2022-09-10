package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.RequestDomain
import debowski.rafal.weatherapp.data.dto.RequestDto

fun RequestDto.toRequestDomain(): RequestDomain =
    RequestDomain(
        type = this.type,
        query = this.query,
        language = this.language,
        unit = this.unit
    )

fun RequestDomain.toRequestDto(): RequestDto =
    RequestDto(
        type = this.type,
        query = this.query,
        language = this.language,
        unit = this.unit
    )