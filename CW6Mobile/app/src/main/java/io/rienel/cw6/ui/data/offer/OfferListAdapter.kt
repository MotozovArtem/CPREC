package io.rienel.cw6.ui.data.offer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Offer

class OfferListAdapter(private val offers: MutableList<Offer>) :
	RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		init {

		}

		fun onBind(offer: Offer) {
			TODO()
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
}