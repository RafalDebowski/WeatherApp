package debowski.rafal.weatherapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RequestEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var currentWeatherId: Long?,
    val type: String,
    val query: String,
    val language: String,
    val unit: String
)