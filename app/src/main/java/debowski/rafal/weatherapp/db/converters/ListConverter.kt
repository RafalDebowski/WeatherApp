package debowski.rafal.weatherapp.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConverter {
    @TypeConverter
    fun stringToModel(listOfStrings: Array<String>?): String? {
        return Gson().toJson(listOfStrings)
    }

    @TypeConverter
    fun modelToString(listOfString: String?): Array<String>? {
        return Gson().fromJson(listOfString, object : TypeToken<Array<String>?>() {}.type)
    }
}