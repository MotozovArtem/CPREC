package io.rienel.cw6.ui.data.position

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.rienel.cw6.R
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.ui.util.Bindable


class PositionListAdapter(private val positions: MutableList<Position>) :
	RecyclerView.Adapter<PositionListAdapter.ViewHolder>() {
	class ViewHolder(view: View) : RecyclerView.ViewHolder(view), Bindable<Position> {
		val idValueTextView: TextView
		val nameValueTextView: TextView
		val salaryValueTextView: TextView

		init {
			idValueTextView = view.findViewById(R.id.positionListItemIdValue)
			nameValueTextView = view.findViewById(R.id.positionListItemNameValue)
			salaryValueTextView = view.findViewById(R.id.positionListItemSalaryValue)
		}

		override fun onBind(obj: Position) {
			obj.let {
				idValueTextView.text = it.positionId
				nameValueTextView.text = it.name
				salaryValueTextView.text = it.salary.toString()
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.position_list_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.onBind(positions[position])
	}

	override fun getItemCount(): Int = positions.size

	fun updatePositions(positions: List<Position>) {
		this.positions.clear()
		this.positions.addAll(positions)
		notifyDataSetChanged()
	}
}