package io.rienel.cw6

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class Cw6Application: Application() {
	override fun onCreate() {
		super.onCreate()
		Timber.plant(Timber.DebugTree())
	}
}