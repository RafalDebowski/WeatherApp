package debowski.rafal.weatherapp.di.modules

import dagger.Module
import dagger.Provides
import debowski.rafal.weatherapp.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        const val BASE_URL = "http://api.weatherstack.com/"
    }

    @Provides
    @Singleton
    fun provideWeatherApi() : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Provides
    fun providesWeatherApi(retrofit: Retrofit) : WeatherApi =
        retrofit.create(WeatherApi::class.java)
}