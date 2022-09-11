package debowski.rafal.weatherapp.repository

import debowski.rafal.weatherapp.data.domain.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {

    fun getCurrentWeatherByCityName(city: String): Single<CurrentWeatherDomain>
    fun insertCurrentWeather(currentWeatherDomain: CurrentWeatherDomain): Single<Long>
    fun insertCurrent(current: CurrentDomain): Completable
    fun insertLocation(location: LocationDomain): Completable
    fun insertRequest(request: RequestDomain): Completable
    fun getWheatherByCityName(city: String) : Single<Weather>
}