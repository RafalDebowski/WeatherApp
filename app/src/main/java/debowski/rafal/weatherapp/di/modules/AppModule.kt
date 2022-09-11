package debowski.rafal.weatherapp.di.modules

import android.app.Application
import dagger.Binds
import dagger.Module
import debowski.rafal.weatherapp.WeatherApp

@Module
internal abstract class AppModule {

    @Binds
    internal abstract fun bindApplication(app: WeatherApp) : Application
}