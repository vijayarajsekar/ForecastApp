package com.forecastapp.ui.fragments.featureWeather.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.forecastapp.R

class featureWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = featureWeatherFragment()
    }

    private lateinit var viewModel: featureWeatherFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feature_weather_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(featureWeatherFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}