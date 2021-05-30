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

class CurrentWeather : Fragment() {

    companion object {
        fun newInstance() = CurrentWeather()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val weatherstackApi = WeatherstackApi()

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeather = weatherstackApi.getCurrentWeater("Vellore").await()
            txt_respose.text = currentWeather.location.toString()
        }
    }

}