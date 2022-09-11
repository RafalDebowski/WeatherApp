package debowski.rafal.weatherapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import debowski.rafal.weatherapp.db.converters.CurrentConverter
import debowski.rafal.weatherapp.db.converters.LocationConverter
import debowski.rafal.weatherapp.db.converters.RequestConverter

@Entity(tableName = "Current_Weather")
data class CurrentWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @TypeConverters(RequestConverter::class)
    val request: RequestEntity?,
    @TypeConverters(LocationConverter::class)
    val location: LocationEntity?,
    @TypeConverters(CurrentConverter::class)
    val current: CurrentEntity?
)