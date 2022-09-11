package debowski.rafal.weatherapp.api

import debowski.rafal.weatherapp.data.dto.CurrentWeatherDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        const val ACCESS_KEY = "8cd75e9625137e645ea12da72f711268"
    }

    @GET("current?access_key=${ACCESS_KEY}")
    fun getCurrentWeatherByCityName(
        @Query("query") query: String
    ): Single<CurrentWeatherDto>
}