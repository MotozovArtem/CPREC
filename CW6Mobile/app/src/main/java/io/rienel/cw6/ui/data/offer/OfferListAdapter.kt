package io.rienel.cw6.ui.data.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.ui.util.Bindable
import java.time.format.DateTimeFormatter

class OfferListAdapter(private val offers: MutableList<Offer>) :
	RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<Offer> {
		private val idTextView: TextView
		private val serialNumberTextView: TextView
		private val endingDateTextView: TextView
		private val signDateTextView: TextView
		private val startDateTextView: TextView
		private val clientIdTextView: TextView
		private val stuffIdTextView: TextView
		private val officeIdTextView: TextView

		init {
			idTextView = view.findViewById(R.id.offerListItemIdValue)
			serialNumberTextView = view.findViewById(R.id.offerListItemSerialNumberValue)
			endingDateTextView = view.findViewById(R.id.offerListItemEndingDateValue)
			signDateTextView = view.findViewById(R.id.offerListItemSigningDateValue)
			startDateTextView = view.findViewById(R.id.offerListItemStartDateValue)
			clientIdTextView = view.findViewById(R.id.offerListItemClientValue)
			stuffIdTextView = view.findViewById(R.id.offerListItemStuffValue)
			officeIdTextView = view.findViewById(R.id.offerListItemOfficeValue)
		}

		override fun onBind(obj: Offer) {
			obj.let {
				idTextView.text = it.offerId
				serialNumberTextView.text = it.serialNumber
				endingDateTextView.text = it.endingDate.format(DateTimeFormatter.ISO_DATE)
				signDateTextView.text = it.signDate.format(DateTimeFormatter.ISO_DATE)
				startDateTextView.text = it.startDate.format(DateTimeFormatter.ISO_DATE)
				clientIdTextView.text = it.clientId
				stuffIdTextView.text = it.stuffId
				officeIdTextView.text = it.offerId
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.offer_list_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(offers[position])
	}

	override fun getItemCount(): Int = offers.size

	fun updateOffers(offerList: List<Offer>) {
		this.offers.clear()
		this.offers.addAll(offerList)
		notifyDataSetChanged()
	}
}