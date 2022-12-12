package io.rienel.cw6.ui.data.offer

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
import io.rienel.cw6.databinding.OfferListFragmentBinding

@AndroidEntryPoint
class OfferListFragment : Fragment(R.layout.offer_list_fragment) {

	private val offerListViewModel: OfferListViewModel by viewModels()

	private var _binding: OfferListFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = OfferListFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		val adapter = OfferListAdapter(mutableListOf())
		binding.offerListRecyclerView.layoutManager = LinearLayoutManager(view.context)
		binding.offerListRecyclerView.adapter = adapter
		binding.offerListRefresher.setOnRefreshListener {
			offerListViewModel.getOffers()
		}
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		offerListViewModel.getOffers()
		offerListViewModel.responseResult.observe(viewLifecycleOwner) {
			Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
			binding.offerListRefresher.isRefreshing = false
		}
		offerListViewModel.offerList.observe(viewLifecycleOwner) { offerList ->
			offerList?.let {
				(binding.offerListRecyclerView.adapter as OfferListAdapter).updateOffers(it)
			}
		}
	}
}