package io.rienel.cw6.ui.data.office

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.OfficeListFragmentBinding

@AndroidEntryPoint
class OfficeListFragment : Fragment(R.layout.office_list_fragment) {

	private val officeListViewModel: OfficeListViewModel by viewModels()

	private var _binding: OfficeListFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = OfficeListFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		val adapter = OfficeListAdapter(mutableListOf())
		binding.officeListRecyclerView.layoutManager = LinearLayoutManager(view.context)
		binding.officeListRecyclerView.adapter = adapter
		binding.officeListRefresher.setOnRefreshListener {
			officeListViewModel.getOffices()
		}
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		officeListViewModel.getOffices()
		officeListViewModel.responseResult.observe(viewLifecycleOwner) {
			Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
			binding.officeListRefresher.isRefreshing = false
		}
		officeListViewModel.officesList.observe(viewLifecycleOwner) { officesList ->
			officesList?.let {
				(binding.officeListRecyclerView.adapter as OfficeListAdapter).updateOffices(it)
			}
		}
	}
}