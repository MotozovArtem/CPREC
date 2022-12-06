package io.rienel.cw6.ui.data.office

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.ui.Bindable
import java.time.format.DateTimeFormatter

class OfficeListAdapter(private val offices: MutableList<Office>) :
	RecyclerView.Adapter<OfficeListAdapter.ViewHolder>() {
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<Office> {
		private val idTextView: TextView
		private val nameTextView: TextView
		private val addressTextView: TextView
		private val lawAddressTextView: TextView
		private val cabinetsCountTextView: TextView

		init {
			idTextView = view.findViewById(R.id.officeListItemIdValue)
			nameTextView = view.findViewById(R.id.officeListItemNameValue)
			addressTextView = view.findViewById(R.id.officeListItemAddressValue)
			lawAddressTextView = view.findViewById(R.id.officeListItemLawAddressValue)
			cabinetsCountTextView = view.findViewById(R.id.officeListItemCabinetsCountValue)
		}

		override fun onBind(obj: Office) {
			obj.let {
				idTextView.text = it.officeId
				nameTextView.text = it.name
				addressTextView.text = it.address
				lawAddressTextView.text = it.lawAddress
				cabinetsCountTextView.text = it.cabinetsCount
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.office_list_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(offices[position])
	}

	override fun getItemCount(): Int = offices.size

	fun updateOffices(offices: List<Office>) {
		this.offices.clear()
		this.offices.addAll(offices)
		notifyDataSetChanged()
	}

}