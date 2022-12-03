package io.rienel.cw6.ui.data.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Client

class ClientListAdapter(private val clients: MutableList<Client>) :
	RecyclerView.Adapter<ClientListAdapter.ViewHolder>() {

	companion object {
		var maleString = "Male"
		var femaleString = "Female"
	}

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val idTextView: TextView
		val surnameTextView: TextView
		val nameTextView: TextView
		val patronymicTextView: TextView
		val innTextView: TextView
		val passportSerialTextView: TextView
		val phoneTextView: TextView
		val sexTextView: TextView

		init {
			idTextView = view.findViewById(R.id.clientListItemIdValue)
			surnameTextView = view.findViewById(R.id.clientListItemSurnameValue)
			nameTextView = view.findViewById(R.id.clientListItemNameValue)
			patronymicTextView = view.findViewById(R.id.clientListItemPatronymicValue)
			innTextView = view.findViewById(R.id.clientListItemInnValue)
			passportSerialTextView = view.findViewById(R.id.clientListItemPassportSerialValue)
			phoneTextView = view.findViewById(R.id.clientListItemPhoneValue)
			sexTextView = view.findViewById(R.id.clientListItemSexValue)
		}

		fun onBind(client: Client) {
			idTextView.text = client.clientId
			surnameTextView.text = client.surname
			nameTextView.text = client.name
			patronymicTextView.text = client.passportSerial
			innTextView.text = client.inn
			passportSerialTextView.text = client.passportSerial
			phoneTextView.text = client.phone
			sexTextView.text = client.sex
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.client_list_item, parent, false)
		maleString = parent.context.getString(R.string.male)
		femaleString = parent.context.getString(R.string.female)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(clients[position])
	}

	override fun getItemCount(): Int = clients.size

	fun updateClients(clients: List<Client>) {
		this.clients.clear()
		this.clients.addAll(clients)
		notifyDataSetChanged()
	}
}