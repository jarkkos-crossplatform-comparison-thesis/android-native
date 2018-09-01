package fi.jara.thesis.thesisnative

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            val curFragment = supportFragmentManager.findFragmentById(R.id.app_container)
            if (curFragment == null) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.app_container, SelectTestFragment())
                        .commit()
            }
        }
    }
}
