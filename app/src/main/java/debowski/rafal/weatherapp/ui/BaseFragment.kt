package debowski.rafal.weatherapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import debowski.rafal.weatherapp.di.factory.ViewModelFactory
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    open val viewModel: ViewModel? = null

    fun <T : ViewModel> viewModelOf(viewModelClass: KClass<T>): T =
        ViewModelProvider(this, viewModelFactory)[viewModelClass.java]

}