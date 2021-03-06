package fi.jara.thesis.thesisnative.selecttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.selecttest.SelectTestFragmentDirections
import fi.jara.thesis.thesisnative.setOnTouchDownListener
import kotlinx.android.synthetic.main.select_test_fragment.*

class SelectTestFragment: Fragment() {
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onDestroy() {
        super.onDestroy()
        navController = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.select_test_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        open_button_latency_screen_btn.setOnTouchDownListener { _, _ -> showButtonLatencyScreen() }
        open_local_listview_screen_btn.setOnTouchDownListener { _, _ -> showLocalListItemsScreen() }
        open_network_listview_screen_btn.setOnTouchDownListener { _, _ -> showNetworkListItemsScreen() }
        open_heavy_computation_screen_btn.setOnTouchDownListener { _, _ -> showComputationScreen() }
        open_vibration_latency_screen_btn.setOnTouchDownListener { _, _ -> showVibrationLatencyScreen() }
        open_third_party_notices_screen_btn.setOnTouchDownListener { _, _ -> showThirdPartyNoticesScreen() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        open_button_latency_screen_btn.setOnTouchDownListener(null)
        open_local_listview_screen_btn.setOnTouchDownListener(null)
        open_network_listview_screen_btn.setOnTouchDownListener(null)
        open_heavy_computation_screen_btn.setOnTouchDownListener(null)
        open_vibration_latency_screen_btn.setOnTouchDownListener(null)
        open_third_party_notices_screen_btn.setOnTouchDownListener(null)
    }

    private fun showButtonLatencyScreen() {
        navController?.navigate(SelectTestFragmentDirections.openButtonLatencyScreen())
    }

    private fun showLocalListItemsScreen() {
        navController?.navigate(SelectTestFragmentDirections.openFilesystemListitemsScreen())
    }

    private fun showNetworkListItemsScreen() {
        navController?.navigate(SelectTestFragmentDirections.openNetworkListitemsScreen())
    }

    private fun showComputationScreen() {
        navController?.navigate(SelectTestFragmentDirections.openHeavyComputationScreen())
    }

    private fun showVibrationLatencyScreen() {
        navController?.navigate(SelectTestFragmentDirections.openVibrationLatencyScreen())
    }

    private fun showThirdPartyNoticesScreen() {
        navController?.navigate(SelectTestFragmentDirections.openThirdPartyNoticesScreen())
    }
}