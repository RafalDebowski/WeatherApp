package debowski.rafal.weatherapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import debowski.rafal.weatherapp.di.DaggerAppComponent

class WeatherApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}