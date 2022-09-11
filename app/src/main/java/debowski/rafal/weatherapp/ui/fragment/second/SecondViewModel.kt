package debowski.rafal.weatherapp.ui.fragment.second

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import debowski.rafal.weatherapp.data.domain.CurrentWeatherDomain
import debowski.rafal.weatherapp.useCase.WeatherUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SecondViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var currentWeather: MutableLiveData<CurrentWeatherDomain>

    fun getCurrentWeatherByCityName(city: String) {
        val disposable = weatherUseCase
            .getCurrentWeatherByCityName(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                currentWeather.postValue(it)
            }, { error ->
                Log.e("ERROR", error.message.toString())
            })

        compositeDisposable.add(disposable)
    }
}