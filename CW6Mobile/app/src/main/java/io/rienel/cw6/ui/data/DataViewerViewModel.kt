package io.rienel.cw6.ui.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.R
import javax.inject.Inject

@HiltViewModel
class DataViewerViewModel @Inject constructor(
) : ViewModel() {
	enum class DataType(
		val position: Int,
		val textResource: Int
	) {
		CLIENT(0, R.string.client),
		OFFER(1, R.string.offer),
		OFFICE(2, R.string.office),
		STUFF(3, R.string.stuff),
		POSITION(4, R.string.position);


		companion object {
			fun getDataType(position: Int): DataType {
				for (value in values()) {
					if (value.position == position) {
						return value
					}
				}
				throw IllegalArgumentException("Illegal position")
			}
		}
	}

	val selectedDataType: LiveData<DataType> = MutableLiveData(DataType.CLIENT)

	var previousDataType: DataType = DataType.CLIENT
}