package debowski.rafal.weatherapp.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import debowski.rafal.weatherapp.db.AppDatabase
import javax.inject.Singleton

@Module
class RoomModule {

    companion object {
        const val APP_DATABASE_NAME = "WEATHER_DATABASE"
    }

    @Provides
    @Singleton
    fun providesRoomDatabase(application: Application) : AppDatabase =
        Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            APP_DATABASE_NAME
        ).build()
}