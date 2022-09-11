package debowski.rafal.weatherapp.useCase

import debowski.rafal.weatherapp.data.domain.*
import debowski.rafal.weatherapp.repository.WeatherRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class WeatherUseCase(
    private val weatherRepository: WeatherRepository
) {

    fun getCurrentWeatherByCityNameFromAPI(city: String): Single<CurrentWeatherDomain> =
        weatherRepository.getCurrentWeatherByCityName(city)

    fun insertCurrentWeather(currentWeatherDomain: CurrentWeatherDomain): Completable =
        weatherRepository.insertCurrentWeather(currentWeatherDomain).flatMapCompletable {
            saveData(it, currentWeatherDomain)
        }

    private fun saveData(id: Long, currentWeatherDomain: CurrentWeatherDomain): Completable =
        weatherRepository.insertCurrent(currentWeatherDomain.current!!.apply {
            this.currentWeatherId = id
        })
            .andThen(
                weatherRepository.insertLocation(currentWeatherDomain.location!!.apply {
                    this.currentWeatherId = id
                })
            )
            .andThen(
                weatherRepository.insertRequest(currentWeatherDomain.request!!.apply {
                    this.currentWeatherId = id
                })
            )

    fun getWheatherByCityNameFromDB(cityName: String): Single<Weather> =
        weatherRepository.getWheatherByCityName(cityName)

}