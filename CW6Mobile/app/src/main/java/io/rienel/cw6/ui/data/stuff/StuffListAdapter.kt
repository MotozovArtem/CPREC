package io.rienel.cw6.ui.data.stuff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.ui.util.Bindable
import java.time.format.DateTimeFormatter

class StuffListAdapter(private val stuffs: MutableList<Stuff>) :
	RecyclerView.Adapter<StuffListAdapter.ViewHolder>() {

	companion object {
		var maleString = "Male"
		var femaleString = "Female"
	}

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<Stuff> {
		val idTextView: TextView
		val surnameTextView: TextView
		val nameTextView: TextView
		val patronymicTextView: TextView
		val sexTextView: TextView
		val birthDateTextView: TextView
		val salaryMultiplierTextView: TextView
		val positionTextView: TextView

		init {
			idTextView = view.findViewById(R.id.stuffListItemIdValue)
			surnameTextView = view.findViewById(R.id.stuffListItemSurnameValue)
			nameTextView = view.findViewById(R.id.stuffListItemNameValue)
			patronymicTextView = view.findViewById(R.id.stuffListItemPatronymicValue)
			sexTextView = view.findViewById(R.id.stuffListItemSexValue)
			birthDateTextView = view.findViewById(R.id.stuffListItemBirthDateValue)
			salaryMultiplierTextView = view.findViewById(R.id.stuffListItemSalaryMultiplierValue)
			positionTextView = view.findViewById(R.id.stuffListItemPositionValue)
		}


		override fun onBind(obj: Stuff) {
			idTextView.text = obj.stuffId
			surnameTextView.text = obj.surname
			nameTextView.text = obj.name
			patronymicTextView.text = obj.patronymic
			sexTextView.text = obj.sex
			birthDateTextView.text = obj.birthDate.format(DateTimeFormatter.ISO_DATE)
			salaryMultiplierTextView.text = String.format("%.2f", obj.salaryMultiplier)
			positionTextView.text = obj.positionId
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.stuff_list_item, parent, false)
		maleString = parent.context.getString(R.string.male)
		femaleString = parent.context.getString(R.string.female)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(stuffs[position])
	}

	override fun getItemCount(): Int = stuffs.size

	fun updateStuffs(stuffList: List<Stuff>) {
		stuffs.clear()
		stuffs.addAll(stuffList)
		notifyDataSetChanged()
	}
}