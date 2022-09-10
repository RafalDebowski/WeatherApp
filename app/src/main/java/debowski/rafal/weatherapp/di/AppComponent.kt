package debowski.rafal.weatherapp.di

import dagger.Component
import debowski.rafal.weatherapp.di.modules.ApiModule
import debowski.rafal.weatherapp.di.modules.RoomModule
import debowski.rafal.weatherapp.di.modules.WeatherModule
import debowski.rafal.weatherapp.di.modules.WeatherRepositoryModule
import debowski.rafal.weatherapp.ui.activity.MainActivity

@Component(
    modules = [
        ApiModule::class,
        RoomModule::class,
        WeatherRepositoryModule::class,
        WeatherModule::class
    ]
)
interface AppComponent {

    fun injectApp(mainActivity: MainActivity)
}