package debowski.rafal.weatherapp.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import debowski.rafal.weatherapp.WeatherApp
import debowski.rafal.weatherapp.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        ApiModule::class,
        RoomModule::class,
        WeatherRepositoryModule::class,
        WeatherModule::class,
        FirstViewModule::class,
        SecondViewModule::class
    ]
)
interface AppComponent : AndroidInjector<WeatherApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Factory<WeatherApp> {

        override fun create(instance: WeatherApp): AndroidInjector<WeatherApp> {
            seedApplication(instance)
            return build()
        }

        @BindsInstance
        internal abstract fun seedApplication(application: WeatherApp)

        internal abstract fun build(): AppComponent

    }
}