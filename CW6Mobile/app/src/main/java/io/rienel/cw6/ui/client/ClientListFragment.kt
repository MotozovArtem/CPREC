package io.rienel.cw6.ui.client

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rienel.cw6.R

class ClientListFragment : Fragment() {

	companion object {
		fun newInstance() = ClientListFragment()
	}

	private lateinit var viewModel: ClientListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return inflater.inflate(R.layout.client_list_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(ClientListViewModel::class.java)
		// TODO: Use the ViewModel
	}

}