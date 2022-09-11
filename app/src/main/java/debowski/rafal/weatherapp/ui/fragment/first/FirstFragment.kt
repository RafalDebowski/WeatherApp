package debowski.rafal.weatherapp.ui.fragment.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import debowski.rafal.weatherapp.R
import debowski.rafal.weatherapp.databinding.FragmentFirstBinding
import debowski.rafal.weatherapp.ui.BaseFragment
import debowski.rafal.weatherapp.ui.activity.MainActivity
import debowski.rafal.weatherapp.ui.activity.MainActivity.Companion.CITY_NAME

class FirstFragment : BaseFragment() {

    private lateinit var binding: FragmentFirstBinding

    override val viewModel: FirstViewModel by lazy {
        viewModelOf(
            FirstViewModel::class
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        observeActions()

        return binding.root
    }

    private fun observeActions() {
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is FirstViewModel.Action.SaveSuccess -> {
                    val bundle = Bundle().apply {
                        this.putString(CITY_NAME, binding.cityEditText.text.toString())
                    }
                    findNavController().navigate(
                        R.id.action_FirstFragment_to_SecondFragment,
                        bundle
                    )
                }
                is FirstViewModel.Action.ShowError -> {
                    Toast.makeText(
                        context,
                        action.message ?: getString(R.string.data_loading_error),
                        Toast.LENGTH_LONG
                    ).show()
                }
                is FirstViewModel.Action.GetDataFromApi -> {
                    if (checkNetworkConnection()) {
                        viewModel.getCurrentWeatherByCityNameFromAPI(action.cityName)
                    } else {
                        viewModel.action.value = FirstViewModel.Action.ShowError(
                            getString(R.string.no_internet)
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

    private fun initButtons() {
        binding.buttonFirst.setOnClickListener {
            binding.cityEditText.text?.let {
                if (viewModel.isCanCheckWeather(it.toString())) {
                    viewModel.getCurrentWeatherByCityNameFromDB(it.toString().uppercase())
                } else {
                    viewModel.action.value = FirstViewModel.Action.ShowError(
                        getString(R.string.Invalid_city_name)
                    )
                }
            }
        }
    }

    private fun checkNetworkConnection(): Boolean {
        return (activity as? MainActivity)?.isOnline() ?: false
    }

}