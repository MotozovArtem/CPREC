package io.rienel.cw6.ui.data.position

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rienel.cw6.R

class PositionListFragment : Fragment() {

	companion object {
		fun newInstance() = PositionListFragment()
	}

	private lateinit var viewModel: PositionListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.position_list_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(PositionListViewModel::class.java)
		// TODO: Use the ViewModel
	}

}