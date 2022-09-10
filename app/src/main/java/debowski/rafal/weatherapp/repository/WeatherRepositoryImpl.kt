package debowski.rafal.weatherapp.repository

import debowski.rafal.weatherapp.api.WeatherApi
import debowski.rafal.weatherapp.db.AppDatabase
import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class WeatherRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override fun getCurrentWeatherByCityName(city: String): Single<Response<CurrentWeatherDto>> =
        weatherApi.getCurrentWeatherByCityName(city)

}