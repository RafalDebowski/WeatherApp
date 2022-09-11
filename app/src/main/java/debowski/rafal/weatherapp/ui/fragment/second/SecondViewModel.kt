package debowski.rafal.weatherapp.ui.fragment.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import debowski.rafal.weatherapp.data.domain.Weather
import debowski.rafal.weatherapp.useCase.WeatherUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var action = MutableLiveData<Action>()
    var currentWeather = MutableLiveData<Weather>()

    var cityName = MutableLiveData<String>()

    fun getCurrentWeatherByCityName(cityName: String) {
        val disposable = weatherUseCase
            .getWheatherByCityNameFromDB(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                currentWeather.postValue(it)
            }, { error ->
                action.postValue(Action.ShowError(error.message.toString()))
            })

        compositeDisposable.add(disposable)
    }

    sealed class Action {
        data class ShowError(
            val message: String
        ) : Action()
    }
}