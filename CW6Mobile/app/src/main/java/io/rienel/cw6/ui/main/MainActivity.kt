package io.rienel.cw6.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.ActivityMainBinding
import io.rienel.cw6.ui.data.DataViewActivity
import io.rienel.cw6.ui.offer.NewOfferActivity
import io.rienel.cw6.ui.statistic.StatisticActivity
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

		with(binding) {
			newOfferButton.setOnClickListener {
				val intent = Intent(this@MainActivity, NewOfferActivity::class.java)
				startActivity(intent)
			}
			viewStatisticButton.setOnClickListener {
				val intent = Intent(this@MainActivity, StatisticActivity::class.java)
				startActivity(intent)
			}
			serverIpEditText.addTextChangedListener {
				Timber.i("Server IP: %s", it.toString())
				try {
					viewModel.setServerIp(it.toString())
				} catch (e: IllegalArgumentException) {
					Toast.makeText(
						this@MainActivity,
						getString(R.string.ip_cannot_be_empty),
						Toast.LENGTH_SHORT
					).show()
					Timber.i("Invalid IP")
				}
			}

			viewDataButton.setOnClickListener {
				val intent = Intent(this@MainActivity, DataViewActivity::class.java)
				startActivity(intent)
			}
		}
	}
}