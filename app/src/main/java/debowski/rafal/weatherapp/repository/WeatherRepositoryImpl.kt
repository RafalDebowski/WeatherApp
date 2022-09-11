package debowski.rafal.weatherapp.repository

import debowski.rafal.weatherapp.api.WeatherApi
import debowski.rafal.weatherapp.data.domain.*
import debowski.rafal.weatherapp.data.mapper.*
import debowski.rafal.weatherapp.db.AppDatabase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class WeatherRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val weatherApi: WeatherApi
) : WeatherRepository {

    private val currentWeatherDao = appDatabase.currentWeatherDao()
    private val currentDao = appDatabase.currentDao()
    private val locationDao = appDatabase.locationDao()
    private val requestDao = appDatabase.requestDao()

    override fun getCurrentWeatherByCityName(city: String): Single<CurrentWeatherDomain> =
        weatherApi.getCurrentWeatherByCityName(city).map {
            it.toCurrentWeatherDomain()
        }

    override fun insertCurrentWeather(currentWeatherDomain: CurrentWeatherDomain): Single<Long> {
        return currentWeatherDao.insertCurrentWeather(
            currentWeatherDomain.toCurrentWeatherEntity()
        )
    }

    override fun insertCurrent(current: CurrentDomain): Completable =
        currentDao.insertCurrent(current.toCurrentEntity())

    override fun insertLocation(location: LocationDomain): Completable =
        locationDao.insertLocation(location.toLocationEntity())

    override fun insertRequest(request: RequestDomain): Completable =
        requestDao.insertRequest(request.toRequestEntity())

    override fun getWheatherByCityName(city: String): Single<Weather> =
        currentWeatherDao.getWheatherByCityName(city)
}