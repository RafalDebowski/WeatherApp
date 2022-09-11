package debowski.rafal.weatherapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import debowski.rafal.weatherapp.data.entity.CurrentEntity
import debowski.rafal.weatherapp.data.entity.LocationEntity

class CurrentConverter {

    @TypeConverter
    fun modelToString(item: CurrentEntity?): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToModel(json: String?): CurrentEntity? {
        return Gson().fromJson(json, CurrentEntity::class.java)
    }
}