package io.rienel.cw6.ui.data

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R
import io.rienel.cw6.databinding.ActivityDataViewBinding
import io.rienel.cw6.ui.data.client.ClientListFragment
import io.rienel.cw6.ui.data.offer.OfferListFragment
import io.rienel.cw6.ui.data.office.OfficeListFragment
import io.rienel.cw6.ui.data.position.PositionListFragment
import io.rienel.cw6.ui.data.stuff.StuffListFragment
import timber.log.Timber

@AndroidEntryPoint
class DataViewActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDataViewBinding

	private val dataViewerViewModel: DataViewerViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDataViewBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)

//		supportFragmentManager.commit {
//			setReorderingAllowed(true)
//			add<ClientListFragment>(R.id.dataListFragmentContainer, null)
//		}
		binding.dataViewPager.adapter = DataViewPagerAdapter(this)
		with(binding){
			TabLayoutMediator(allTabsLayout, dataViewPager) { tab, position ->
				Timber.i("Swap to $position")
				tab.text = getString(DataViewerViewModel.DataType.getDataType(position).textResource)
			}.attach()
		}

	}

	class DataViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
		override fun getItemCount(): Int = DataViewerViewModel.DataType.values().size
		override fun createFragment(position: Int): Fragment {
			return when (DataViewerViewModel.DataType.getDataType(position)) {
				DataViewerViewModel.DataType.CLIENT -> {
					ClientListFragment()
				}
				DataViewerViewModel.DataType.OFFER -> {
					OfferListFragment()
				}
				DataViewerViewModel.DataType.OFFICE -> {
					OfficeListFragment()
				}
				DataViewerViewModel.DataType.STUFF -> {
					StuffListFragment()
				}
				DataViewerViewModel.DataType.POSITION -> {
					PositionListFragment()
				}
			}
		}
	}
}