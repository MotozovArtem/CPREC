package io.rienel.cw6.ui.data

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.ui.data.client.ClientListFragment

@AndroidEntryPoint
class DataViewActivity : AppCompatActivity() {

	private val dataViewerViewModel: DataViewerViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_data_view)
		supportFragmentManager.commit {
			setReorderingAllowed(true)
			add<ClientListFragment>(R.id.dataListFragmentContainer, null)
		}
	}
}