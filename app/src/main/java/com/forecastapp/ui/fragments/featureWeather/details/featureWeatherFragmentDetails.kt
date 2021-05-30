package com.forecastapp.ui.fragments.featureWeather.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.forecastapp.R

class featureWeatherFragmentDetails : Fragment() {

    companion object {
        fun newInstance() = featureWeatherFragmentDetails()
    }

    private lateinit var fragmentViewModel: featureWeatherDetailsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feature_weather_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentViewModel = ViewModelProvider(this).get(featureWeatherDetailsFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}