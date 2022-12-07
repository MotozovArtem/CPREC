package io.rienel.cw6.ui.offer

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.databinding.ActivityNewOfferBinding
import timber.log.Timber
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@AndroidEntryPoint
class NewOfferActivity : AppCompatActivity() {

	private lateinit var binding: ActivityNewOfferBinding

	private val newOfferViewModel: NewOfferViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityNewOfferBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		newOfferViewModel.getAllForeignData()
		with(binding) {
			signDateEdit.setText(
				LocalDate.now().format(DateTimeFormatter.ISO_DATE),
				TextView.BufferType.EDITABLE
			)
			newOfferViewModel.clients.observe(this@NewOfferActivity) {
				clientSpinner.adapter =
					ArrayAdapter(this@NewOfferActivity, android.R.layout.simple_spinner_item, it)
			}
			newOfferViewModel.stuffs.observe(this@NewOfferActivity) {
				stuffSpinner.adapter =
					ArrayAdapter(this@NewOfferActivity, android.R.layout.simple_spinner_item, it)
			}
			clientSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
				override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
					newOfferViewModel.selectedClient = newOfferViewModel.clients.value?.get(position)
				}

				override fun onNothingSelected(p0: AdapterView<*>?) {
					Timber.i("ClientSpinner: Nothing  selected")
					newOfferViewModel.selectedClient = null
				}
			}
			stuffSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
				override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
					newOfferViewModel.selectedStuff = newOfferViewModel.stuffs.value?.get(position)
				}

				override fun onNothingSelected(p0: AdapterView<*>?) {
					Timber.i("ClientSpinner: Nothing  selected")
					newOfferViewModel.selectedStuff = null
				}
			}
			saveNewOffer.setOnClickListener {
				val startDate = try {
					LocalDate.parse(binding.startDate.text)
				} catch (e: DateTimeParseException) {
					Toast.makeText(
						this@NewOfferActivity,
						"Illegal start date format",
						Toast.LENGTH_SHORT
					).show()
					null
				}
				val endingDate = try {
					LocalDate.parse(binding.endingDate.text)
				} catch (e: DateTimeParseException) {
					Toast.makeText(
						this@NewOfferActivity,
						"Illegal start date format",
						Toast.LENGTH_SHORT
					).show()
					null
				}
				if (startDate == null || endingDate == null) return@setOnClickListener
				newOfferViewModel.saveNewOffer(startDate, endingDate).observe(this@NewOfferActivity) { receivedOffer ->
					if (receivedOffer == null) {
						Timber.i("Save failed")
						Toast.makeText(
							this@NewOfferActivity,
							"Creating new offer failed. Check logs!",
							Toast.LENGTH_SHORT
						).show()
					} else {
						Toast.makeText(
							this@NewOfferActivity,
							"Creating new offer with id ${receivedOffer.id}",
							Toast.LENGTH_LONG
						).show()
					}
				}
			}
		}
	}
}