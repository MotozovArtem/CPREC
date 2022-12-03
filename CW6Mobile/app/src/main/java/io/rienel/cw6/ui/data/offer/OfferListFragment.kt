package io.rienel.cw6.ui.data.offer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.rienel.cw6.R

class OfferListFragment : Fragment() {

	companion object {
		fun newInstance() = OfferListFragment()
	}

	private lateinit var viewModel: OfferListViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.offer_list_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProvider(this).get(OfferListViewModel::class.java)
		// TODO: Use the ViewModel
	}

}