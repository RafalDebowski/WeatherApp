package debowski.rafal.weatherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import debowski.rafal.weatherapp.data.entity.CurrentEntity
import debowski.rafal.weatherapp.data.entity.CurrentWeatherEntity
import debowski.rafal.weatherapp.data.entity.LocationEntity
import debowski.rafal.weatherapp.data.entity.RequestEntity
import debowski.rafal.weatherapp.db.converters.CurrentConverter
import debowski.rafal.weatherapp.db.converters.ListConverter
import debowski.rafal.weatherapp.db.converters.LocationConverter
import debowski.rafal.weatherapp.db.converters.RequestConverter
import debowski.rafal.weatherapp.db.dao.CurrentDao
import debowski.rafal.weatherapp.db.dao.CurrentWeatherDAO
import debowski.rafal.weatherapp.db.dao.LocationDao
import debowski.rafal.weatherapp.db.dao.RequestDao

@Database(
    entities = [
        CurrentWeatherEntity::class,
        RequestEntity::class,
        LocationEntity::class,
        CurrentEntity::class
    ],
    version = 5,
    exportSchema = false
)
@TypeConverters(
    CurrentConverter::class,
    ListConverter::class,
    LocationConverter::class,
    RequestConverter::class
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun currentWeatherDao(): CurrentWeatherDAO

    abstract fun currentDao() : CurrentDao

    abstract fun locationDao() : LocationDao

    abstract fun requestDao() : RequestDao
}