package com.dangbei.android_hilt.navigationModule

enum class Screens {
    BUTTONS,
    LOGS
}

interface AppNavigator {

    fun navigateTo(screens: Screens)

}