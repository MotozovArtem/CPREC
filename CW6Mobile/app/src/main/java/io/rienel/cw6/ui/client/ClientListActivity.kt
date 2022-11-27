package io.rienel.cw6.ui.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.rienel.cw6.R

class ClientListActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.client_list_activity)
		if (savedInstanceState == null) {
			supportFragmentManager.beginTransaction()
				.replace(R.id.container, ClientListFragment.newInstance())
				.commitNow()
		}
	}
}