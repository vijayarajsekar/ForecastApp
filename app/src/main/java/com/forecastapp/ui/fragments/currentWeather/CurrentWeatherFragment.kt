package com.forecastapp.ui.fragments.currentWeather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.forecastapp.R
import com.forecastapp.data.WeatherstackApi
import kotlinx.android.synthetic.main.current_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    private lateinit var fragmentViewModel: CurrentWeatherFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentViewModel = ViewModelProvider(this).get(CurrentWeatherFragmentViewModel::class.java)
        // TODO: Use the ViewModel

        val weatherstackApi = WeatherstackApi()

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeather = weatherstackApi.getCurrentWeater("Vellore").await()
            txt_respose.text = currentWeather.toString()
        }
    }

}