package io.rienel.cw6.ui.statistic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.cw6.R

@AndroidEntryPoint
class StatisticActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_statistic)
		supportFragmentManager.commit {
			setReorderingAllowed(true);
			add<StatisticsFragment>(R.id.statisticActivityFragmentContainer, null)
		}
	}
}