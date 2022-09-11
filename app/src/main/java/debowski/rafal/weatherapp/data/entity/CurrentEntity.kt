package debowski.rafal.weatherapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import debowski.rafal.weatherapp.db.converters.ListConverter

@Entity
class CurrentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var currentWeatherId: Long?,
    val observationTime: String,
    val temperature: Int,
    val weatherCode: Int,
    @TypeConverters(ListConverter::class)
    val weatherIcons: Array<String>?,
    @TypeConverters(ListConverter::class)
    val weatherDescriptions: Array<String>?,
    val windSpeed: Int,
    val windDegree: Int,
    val windDir: String,
    val pressure: Int,
    val humidity: Int,
    val cloudCover: Int,
    val feelsLike: Int,
    val uvIndex: Int,
    val visibility: Int
)