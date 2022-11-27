package io.rienel.cw6.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.StatisticsFragmentBinding

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.statistics_fragment) {

	private val statisticsViewModel: StatisticsViewModel by viewModels()

	private var _binding: StatisticsFragmentBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = StatisticsFragmentBinding.inflate(inflater, container, false)
		val view = binding.root
		return view
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		statisticsViewModel.getOfferStatistic().observe(viewLifecycleOwner) { statistic ->
			statistic.stuffStatistics?.let {
				binding.offerCount.text = it.values.sum().toString()
				binding.stuffStatistic.text = it.toString()
			}
			statistic.clientStatistics?.let {
				binding.clientStatistic.text = it.toString()
			}
			statistic.clientSurnames?.let {
				binding.clientSurnames.text = it.toString()
			}
		}
	}
}