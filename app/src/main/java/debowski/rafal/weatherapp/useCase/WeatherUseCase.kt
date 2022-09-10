package debowski.rafal.weatherapp.useCase

import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto
import debowski.rafal.weatherapp.repository.WeatherRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class WeatherUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getCurrentWeatherByCityName(city: String) : Single<Response<CurrentWeatherDto>> =
        weatherRepository.getCurrentWeatherByCityName(city)

}