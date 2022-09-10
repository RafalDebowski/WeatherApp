package debowski.rafal.weatherapp.di.modules

import dagger.Module
import dagger.Provides
import debowski.rafal.weatherapp.api.WeatherApi
import debowski.rafal.weatherapp.db.AppDatabase
import debowski.rafal.weatherapp.repository.WeatherRepository
import debowski.rafal.weatherapp.repository.WeatherRepositoryImpl

@Module
class WeatherRepositoryModule {

    @Provides
    fun provideWeatherRepositoryImpl(
        appDatabase: AppDatabase,
        weatherApi: WeatherApi
    ) : WeatherRepository =
        WeatherRepositoryImpl(
            appDatabase = appDatabase,
            weatherApi = weatherApi
        )
}