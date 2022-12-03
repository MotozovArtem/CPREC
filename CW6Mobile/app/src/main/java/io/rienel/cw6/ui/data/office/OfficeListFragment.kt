package io.rienel.cw6.ui.data.office

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rienel.cw6.R

class OfficeListFragment : Fragment() {

	companion object {
		fun newInstance() = OfficeListFragment()
	}

	private lateinit var viewModel: OfficeListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.office_list_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(OfficeListViewModel::class.java)
		// TODO: Use the ViewModel
	}

}