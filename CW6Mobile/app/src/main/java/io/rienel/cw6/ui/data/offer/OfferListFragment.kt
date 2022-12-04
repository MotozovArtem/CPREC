package io.rienel.cw6.ui.data.offer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}