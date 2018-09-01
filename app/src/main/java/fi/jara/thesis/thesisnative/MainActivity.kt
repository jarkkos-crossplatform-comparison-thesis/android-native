package fi.jara.thesis.thesisnative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val viewNavigator: ViewNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewNavigator.activity = this

        if (savedInstanceState == null) {
            val curFragment = supportFragmentManager.findFragmentById(R.id.app_container)
            if (curFragment == null) {
                viewNavigator.gotoSelectTestView()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewNavigator.activity = null
    }
}
