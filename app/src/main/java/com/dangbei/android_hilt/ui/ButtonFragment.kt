package com.dangbei.android_hilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.dangbei.android_hilt.R
import com.dangbei.android_hilt.data.LoggerDataSource
import com.dangbei.android_hilt.di.DatabaseLogger
import com.dangbei.android_hilt.di.InMemoryLogger
import com.dangbei.android_hilt.navigationModule.AppNavigator
import com.dangbei.android_hilt.navigationModule.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ButtonFragment : Fragment(){

    @DatabaseLogger
    @Inject lateinit var logger: LoggerDataSource
    @Inject lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }

    }

}