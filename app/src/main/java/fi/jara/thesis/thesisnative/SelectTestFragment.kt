package fi.jara.thesis.thesisnative

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.buttonlatency.ButtonLatencyFragment
import fi.jara.thesis.thesisnative.computation.ComputationFragment
import fi.jara.thesis.thesisnative.listitems.ListItemsFragment
import fi.jara.thesis.thesisnative.vibration.VibrationFragment
import kotlinx.android.synthetic.main.select_test_fragment.*

class SelectTestFragment: Fragment() {
    private var appNavigator: AppNavigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appNavigator = activity as AppNavigator
    }

    override fun onDestroy() {
        super.onDestroy()
        appNavigator = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.select_test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        open_button_latency_screen_btn.setOnClickListener { showButtonLatencyScreen() }
        open_local_listview_screen_btn.setOnClickListener { showLocalListItemsScreen() }
        open_network_listview_screen_btn.setOnClickListener { showNetworkListItemsScreen() }
        open_heavy_computation_screen_btn.setOnClickListener { showComputationScreen() }
        open_vibration_latency_screen_btn.setOnClickListener { showVibrationLatencyScreen() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        open_button_latency_screen_btn.setOnClickListener(null)
        open_local_listview_screen_btn.setOnClickListener(null)
        open_network_listview_screen_btn.setOnClickListener(null)
        open_heavy_computation_screen_btn.setOnClickListener(null)
        open_vibration_latency_screen_btn.setOnClickListener(null)
    }

    private fun showButtonLatencyScreen() {
        appNavigator?.showFragment(ButtonLatencyFragment())
    }

    private fun showLocalListItemsScreen() {
        appNavigator?.showFragment(ListItemsFragment())
    }

    private fun showNetworkListItemsScreen() {
        appNavigator?.showFragment(ListItemsFragment())
    }

    private fun showComputationScreen() {
        appNavigator?.showFragment(ComputationFragment())
    }

    private fun showVibrationLatencyScreen() {
        appNavigator?.showFragment(VibrationFragment())
    }
}