package debowski.rafal.weatherapp.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import debowski.rafal.weatherapp.di.annotation.ViewModelKey
import debowski.rafal.weatherapp.ui.fragment.first.FirstFragment
import debowski.rafal.weatherapp.ui.fragment.first.FirstViewModel

@Module
abstract class FirstViewModule {

    @ContributesAndroidInjector
    abstract fun contributeSecondFragment() : FirstFragment

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindSecondViewModel(viewModel: FirstViewModel): ViewModel
}