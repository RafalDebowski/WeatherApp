package debowski.rafal.weatherapp.ui.fragment.second

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import coil.load
import debowski.rafal.weatherapp.R
import debowski.rafal.weatherapp.databinding.FragmentSecondBinding
import debowski.rafal.weatherapp.ui.BaseFragment
import debowski.rafal.weatherapp.ui.activity.MainActivity.Companion.CITY_NAME
import okhttp3.HttpUrl

class SecondFragment : BaseFragment() {

    private lateinit var binding: FragmentSecondBinding

    companion object {
        const val DEGREES = "°"
        const val SPACE = " "
    }

    override val viewModel: SecondViewModel by lazy {
        viewModelOf(
            SecondViewModel::class
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        observeData()
        getBundleAndInitData()

        return binding.root
    }

    private fun getBundleAndInitData() {
        arguments?.let {
            viewModel.cityName.value = it.getString(CITY_NAME) as String
        }
    }

    private fun observeData() {
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is SecondViewModel.Action.ShowError -> {
                    Toast.makeText(context, action.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.cityName.observe(viewLifecycleOwner) {
            viewModel.getCurrentWeatherByCityName(it.uppercase())
        }

        viewModel.currentWeather.observe(viewLifecycleOwner) {
            binding.apply {
                this.temperature.text = it.temperature.toString() + DEGREES
                this.feelsLike.text = getString(R.string.feeling) + SPACE + it.feelsLike + DEGREES
                it.weatherIcons?.first()?.let {
                    this.icon.load(it)
                }
                this.name.text = it.name
                this.date.text = it.localTime
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}