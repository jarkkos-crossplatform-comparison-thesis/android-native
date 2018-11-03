package fi.jara.thesis.thesisnative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), AppNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val curFragment = supportFragmentManager.findFragmentById(R.id.app_container)
            if (curFragment == null) {
                showLandingScreen()
            }
        }
    }

    override fun showLandingScreen() {
        supportFragmentManager.popBackStack(BACKSTACK_ROOT, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        showFragment(SelectTestFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.app_container, fragment)
                .addToBackStack(BACKSTACK_ROOT)
                .commit()
    }

    companion object {
        private const val BACKSTACK_ROOT = "backstack_root"
    }
}
