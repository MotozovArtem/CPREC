package io.rienel.cw6.ui.data.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.ClientListFragmentBinding
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine

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
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		clientListViewModel.getClients()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		clientListViewModel.clientsList.observe(viewLifecycleOwner) {
			if (it != null) {
				(binding.clientListRecycler.adapter as ClientListAdapter).updateClients(it)
			}
		}
	}
}