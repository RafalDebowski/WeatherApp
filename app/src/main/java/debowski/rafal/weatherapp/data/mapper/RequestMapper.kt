package debowski.rafal.weatherapp.data.mapper

import debowski.rafal.weatherapp.data.domain.RequestDomain
import debowski.rafal.weatherapp.data.dto.RequestDto
import debowski.rafal.weatherapp.data.entity.RequestEntity

fun RequestDto.toRequestDomain(): RequestDomain =
    RequestDomain(
        type = this.type.orEmpty(),
        query = this.query.orEmpty(),
        language = this.language.orEmpty(),
        unit = this.unit.orEmpty()
    )

fun RequestDomain.toRequestDto(): RequestDto =
    RequestDto(
        type = this.type,
        query = this.query,
        language = this.language,
        unit = this.unit
    )

fun RequestDomain.toRequestEntity(): RequestEntity =
    RequestEntity(
        currentWeatherId = this.currentWeatherId,
        type = this.type,
        query = this.query,
        language = this.language,
        unit = this.unit
    )

fun RequestEntity.toRequestDomain(): RequestDomain =
    RequestDomain(
        id = this.id,
        type = this.type,
        query = this.query,
        language = this.language,
        unit = this.unit
    )