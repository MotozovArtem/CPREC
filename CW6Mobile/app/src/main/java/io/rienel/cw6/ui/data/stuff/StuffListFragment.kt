package io.rienel.cw6.ui.data.stuff

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
import io.rienel.cw6.databinding.StuffListFragmentBinding

@AndroidEntryPoint
class StuffListFragment : Fragment(R.layout.stuff_list_fragment) {

	private val stuffListViewModel: StuffListViewModel by viewModels()

	private var _binding: StuffListFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = StuffListFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		val adapter = StuffListAdapter(mutableListOf())
		binding.stuffRecyclerView.layoutManager = LinearLayoutManager(view.context)
		binding.stuffRecyclerView.adapter = adapter
		binding.stuffListRefresh.setOnRefreshListener {
			stuffListViewModel.getStuffs()
		}
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		stuffListViewModel.getStuffs()
		stuffListViewModel.responseResult.observe(viewLifecycleOwner) {
			Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
			binding.stuffListRefresh.isRefreshing = false
		}
		stuffListViewModel.stuffList.observe(viewLifecycleOwner) { stuffsList ->
			stuffsList?.let {
				(binding.stuffRecyclerView.adapter as StuffListAdapter).updateStuffs(it)
			}
		}
	}
}