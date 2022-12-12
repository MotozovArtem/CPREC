package io.rienel.cw6.ui.data.client

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.ClientListFragmentBinding

@AndroidEntryPoint
class ClientListFragment : Fragment(R.layout.client_list_fragment) {

	private val clientListViewModel: ClientListViewModel by viewModels()

	private var _binding: ClientListFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = ClientListFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		val adapter = ClientListAdapter(mutableListOf())
		binding.clientListRecycler.layoutManager = LinearLayoutManager(view.context)
		binding.clientListRecycler.adapter = adapter
		binding.clientListRefresher.setOnRefreshListener {
			clientListViewModel.getClients()
		}
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		clientListViewModel.getClients()
		clientListViewModel.responseResult.observe(viewLifecycleOwner) {
			Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
			binding.clientListRefresher.isRefreshing = false
		}
		clientListViewModel.clientsList.observe(viewLifecycleOwner) {
			if (it != null) {
				(binding.clientListRecycler.adapter as ClientListAdapter).updateClients(it)
			}
		}
	}


}