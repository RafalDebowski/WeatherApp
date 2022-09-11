package debowski.rafal.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import debowski.rafal.weatherapp.data.entity.RequestEntity
import io.reactivex.rxjava3.core.Completable

@Dao
abstract class RequestDao {

    @Insert
    abstract fun insertRequest(request: RequestEntity) : Completable
}