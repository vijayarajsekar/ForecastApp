package com.forecastapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.forecastapp.R
import com.forecastapp.utils.LogUtils
import kotlinx.android.synthetic.main.activity_home.*

class HomeScreen : AppCompatActivity() {

    private var TAG = "~ ~ ~ " + HomeScreen::class.java.name

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.v(TAG, "onCreate")
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottom_nav.setupWithNavController(mNavController)
        NavigationUI.setupActionBarWithNavController(this, mNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }
}