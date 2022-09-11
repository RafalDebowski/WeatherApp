package debowski.rafal.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import debowski.rafal.weatherapp.data.entity.CurrentWeatherEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class CurrentWeatherDAO {

    @Insert
    abstract fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity) : Single<Long>

//    @Query("SELECT * FROM Current_Weather WHERE ")
//    abstract fun getCurrentWeatherByCityName(cityName: String) : Completable

}