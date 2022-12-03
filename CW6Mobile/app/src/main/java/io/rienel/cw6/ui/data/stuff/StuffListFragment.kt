package io.rienel.cw6.ui.data.stuff

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rienel.cw6.R

class StuffListFragment : Fragment() {

	companion object {
		fun newInstance() = StuffListFragment()
	}

	private lateinit var viewModel: StuffListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.stuff_list_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(StuffListViewModel::class.java)
		// TODO: Use the ViewModel
	}

}