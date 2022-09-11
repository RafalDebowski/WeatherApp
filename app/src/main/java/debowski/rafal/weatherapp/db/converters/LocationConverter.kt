package debowski.rafal.weatherapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import debowski.rafal.weatherapp.data.entity.LocationEntity

class LocationConverter {
    @TypeConverter
    fun modelToString(item: LocationEntity?): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToModel(json: String?): LocationEntity? {
        return Gson().fromJson(json, LocationEntity::class.java)
    }
}