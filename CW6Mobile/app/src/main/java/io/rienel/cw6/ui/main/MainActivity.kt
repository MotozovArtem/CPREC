package io.rienel.cw6.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		supportFragmentManager.commit {
			setReorderingAllowed(true);
			add<StatisticsFragment>(R.id.mainActivityFragmentContainer, null)
		}

		with(binding) {
			newOfferButton.setOnClickListener {

			}
		}
	}
}