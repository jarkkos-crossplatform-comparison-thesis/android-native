package fi.jara.thesis.thesisnative

import androidx.fragment.app.Fragment

interface AppNavigator {
    fun showLandingScreen()
    fun showFragment(fragment: Fragment)
}