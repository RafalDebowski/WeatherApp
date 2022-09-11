package debowski.rafal.weatherapp.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import debowski.rafal.weatherapp.di.annotation.ViewModelKey
import debowski.rafal.weatherapp.ui.fragment.second.SecondFragment
import debowski.rafal.weatherapp.ui.fragment.second.SecondViewModel

@Module
abstract class SecondViewModule {

    @ContributesAndroidInjector
    abstract fun contributeSecondFragment() : SecondFragment

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel
}