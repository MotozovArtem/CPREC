package io.rienel.cw6.ui.data.position

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
import io.rienel.cw6.databinding.PositionListFragmentBinding

@AndroidEntryPoint
class PositionListFragment : Fragment(R.layout.position_list_fragment) {

	private val positionListViewModel: PositionListViewModel by viewModels()

	private var _binding: PositionListFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = PositionListFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		val adapter = PositionListAdapter(mutableListOf())
		binding.positionRecyclerView.layoutManager = LinearLayoutManager(view.context)
		binding.positionRecyclerView.adapter = adapter
		binding.positionListRefresh.setOnRefreshListener {
			positionListViewModel.getPositions()
		}
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		positionListViewModel.getPositions()
		positionListViewModel.responseResult.observe(viewLifecycleOwner) {
			Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
			binding.positionListRefresh.isRefreshing = false
		}
		positionListViewModel.positionList.observe(viewLifecycleOwner) { positionsList ->
			positionsList?.let {
				(binding.positionRecyclerView.adapter as PositionListAdapter).updatePositions(it)
			}
		}
	}
}