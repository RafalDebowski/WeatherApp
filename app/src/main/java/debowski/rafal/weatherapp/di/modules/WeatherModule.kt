package debowski.rafal.weatherapp.di.modules

import dagger.Module
import dagger.Provides
import debowski.rafal.weatherapp.repository.WeatherRepository
import debowski.rafal.weatherapp.useCase.WeatherUseCase

@Module
class WeatherModule {

    @Provides
    fun provideWeatherUseCase(
        weatherRepository: WeatherRepository
    ): WeatherUseCase =
        WeatherUseCase(
            weatherRepository = weatherRepository
        )
}