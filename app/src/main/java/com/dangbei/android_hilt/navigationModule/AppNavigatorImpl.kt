package com.dangbei.android_hilt.navigationModule

import androidx.fragment.app.FragmentActivity
import com.dangbei.android_hilt.R
import com.dangbei.android_hilt.ui.ButtonFragment
import com.dangbei.android_hilt.ui.LogsFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator{

    override fun navigateTo(screens: Screens) {
        val fragment = when (screens){
            Screens.BUTTONS -> ButtonFragment()
            Screens.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()

    }
}