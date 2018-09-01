package fi.jara.thesis.thesisnative

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

class ThesisApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val koinModule: Module = org.koin.dsl.module.applicationContext {
            bean { ViewNavigator() }
        }
        startKoin(this, listOf(koinModule))
    }
}