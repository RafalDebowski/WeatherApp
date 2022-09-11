package debowski.rafal.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import debowski.rafal.weatherapp.data.entity.LocationEntity
import io.reactivex.rxjava3.core.Completable

@Dao
abstract class LocationDao {

    @Insert
    abstract fun insertLocation(location: LocationEntity) : Completable
}