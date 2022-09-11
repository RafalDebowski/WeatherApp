package debowski.rafal.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import debowski.rafal.weatherapp.data.domain.Weather
import debowski.rafal.weatherapp.data.entity.CurrentWeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class CurrentWeatherDAO {

    @Insert
    abstract fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity) : Single<Long>

    @Query("SELECT " +
            "LocationEntity.name as name," +
            "LocationEntity.localTime as localTime," +
            "CurrentEntity.observationTime as observationTime," +
            "CurrentEntity.temperature as temperature," +
            "CurrentEntity.weatherIcons as weatherIcons," +
            "CurrentEntity.weatherDescriptions as weatherDescriptions," +
            "CurrentEntity.feelsLike as feelsLike" +
            " FROM Current_Weather " +
            "JOIN LocationEntity ON Current_Weather.id = LocationEntity.currentWeatherId "+
            "JOIN CurrentEntity ON Current_Weather.id = CurrentEntity.currentWeatherId " +
            "WHERE LocationEntity.name =:cityName")
    abstract fun getWheatherByCityName(cityName: String) : Single<Weather>

}