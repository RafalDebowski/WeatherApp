package debowski.rafal.weatherapp.ui.fragment.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import debowski.rafal.weatherapp.R
import debowski.rafal.weatherapp.databinding.FragmentSecondBinding
import debowski.rafal.weatherapp.ui.BaseFragment
import debowski.rafal.weatherapp.ui.activity.MainActivity.Companion.CITY_NAME

class SecondFragment : BaseFragment() {

    private lateinit var binding: FragmentSecondBinding

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

        arguments?.let {
            Toast.makeText(context, it.getString(CITY_NAME), Toast.LENGTH_LONG).show()
        }
        binding.buttonGet.setOnClickListener {
            viewModel.getCurrentWeatherByCityName("Warszawa")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}