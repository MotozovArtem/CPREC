package io.rienel.cw6.ui.data.office

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		officeListViewModel.getOffices()
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		officeListViewModel.officesList.observe(viewLifecycleOwner) { officesList ->
			officesList?.let {
				(binding.officeListRecyclerView.adapter as OfficeListAdapter).updateOffices(it)
			}
		}
	}
}