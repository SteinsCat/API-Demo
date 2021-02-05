package com.dangbei.android_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dangbei.android_hilt.R
import com.dangbei.android_hilt.navigationModule.AppNavigator
import com.dangbei.android_hilt.navigationModule.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if(supportFragmentManager.backStackEntryCount == 0){
            finish()
        }
    }
}