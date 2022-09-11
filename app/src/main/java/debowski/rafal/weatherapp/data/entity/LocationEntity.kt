package debowski.rafal.weatherapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var currentWeatherId: Long?,
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    val timezoneId: String,
    val localTime: String,
    val localTimeEpoch: String,
    val utcOffset: String
)