package fi.jara.thesis.thesisnative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
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

    private fun showLandingScreen() {
        supportFragmentManager.apply {
            popBackStack(BACKSTACK_ROOT, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            beginTransaction()
                    .replace(R.id.app_container, SelectTestFragment())
                    .addToBackStack(BACKSTACK_ROOT)
                    .commit()
        }
    }

    companion object {
        private const val BACKSTACK_ROOT = "backstack_root"
    }
}
