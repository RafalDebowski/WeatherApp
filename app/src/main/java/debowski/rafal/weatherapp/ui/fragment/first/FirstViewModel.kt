package debowski.rafal.weatherapp.ui.fragment.first

import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import debowski.rafal.weatherapp.data.domain.CurrentWeatherDomain
import debowski.rafal.weatherapp.useCase.WeatherUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FirstViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var action = MutableLiveData<Action>()
    var currentWeatherDomain = MutableLiveData<CurrentWeatherDomain>()
    var canCheckWeather: Boolean = false

    fun getCurrentWeatherByCityNameFromDB(cityName: String) {
        val disposable = weatherUseCase
            .getWheatherByCityNameFromDB(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                action.postValue(Action.SaveSuccess)
            }, {
                action.postValue(Action.GetDataFromApi(cityName))
            })

        compositeDisposable.add(disposable)
    }

    fun isCanCheckWeather(cityName: String) =
        cityName.length > 3 && cityName.isNotEmpty() && cityName.chars().allMatch(Character::isLetter)

    fun getCurrentWeatherByCityNameFromAPI(city: String) {
        val disposable = weatherUseCase
            .getCurrentWeatherByCityNameFromAPI(city)
            .flatMapCompletable {
                currentWeatherDomain.postValue(it)
                weatherUseCase.insertCurrentWeather(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                action.postValue(Action.SaveSuccess)
            }, { error ->
                action.postValue(Action.ShowError(error.message))
            })

        compositeDisposable.add(disposable)
    }

    sealed class Action {
        data class ShowError(
            val message: String?
        ) : Action()

        object SaveSuccess : Action()

        data class GetDataFromApi(
            val cityName: String
        ) : Action()
    }
}