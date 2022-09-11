package debowski.rafal.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import debowski.rafal.weatherapp.data.entity.CurrentEntity
import io.reactivex.rxjava3.core.Completable

@Dao
abstract class CurrentDao {

    @Insert
    abstract fun insertCurrent(current: CurrentEntity) : Completable
}