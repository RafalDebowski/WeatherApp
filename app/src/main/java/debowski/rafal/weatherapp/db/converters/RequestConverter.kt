package debowski.rafal.weatherapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import debowski.rafal.weatherapp.data.entity.RequestEntity

class RequestConverter {
    @TypeConverter
    fun modelToString(item: RequestEntity?): String? {
        return Gson().toJson(item)
    }

    @TypeConverter
    fun stringToModel(json: String?): RequestEntity? {
        return Gson().fromJson(json, RequestEntity::class.java)
    }
}