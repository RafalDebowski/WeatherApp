package debowski.rafal.weatherapp.repository

import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface WeatherRepository {

    fun getCurrentWeatherByCityName(city: String) : Single<Response<CurrentWeatherDto>>
}