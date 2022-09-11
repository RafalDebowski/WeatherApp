package debowski.rafal.weatherapp.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import debowski.rafal.weatherapp.di.factory.ViewModelFactory

@Module(
    includes = [
        AppModule::class
    ]
)
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}