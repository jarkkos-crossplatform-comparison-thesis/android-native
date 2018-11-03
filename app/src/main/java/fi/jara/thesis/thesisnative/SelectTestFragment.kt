package fi.jara.thesis.thesisnative

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
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

        open_button_latency_screen_btn.setOnClickListener { showButtonLatencyScreen() }
        open_local_listview_screen_btn.setOnClickListener { showLocalListItemsScreen() }
        open_network_listview_screen_btn.setOnClickListener { showNetworkListItemsScreen() }
        open_heavy_computation_screen_btn.setOnClickListener { showComputationScreen() }
        open_vibration_latency_screen_btn.setOnClickListener { showVibrationLatencyScreen() }
        open_third_party_notices_screen_btn.setOnClickListener { showThirdPartyNoticesScreen() }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        open_button_latency_screen_btn.setOnClickListener(null)
        open_local_listview_screen_btn.setOnClickListener(null)
        open_network_listview_screen_btn.setOnClickListener(null)
        open_heavy_computation_screen_btn.setOnClickListener(null)
        open_vibration_latency_screen_btn.setOnClickListener(null)
        open_third_party_notices_screen_btn.setOnClickListener(null)
    }

    private fun showButtonLatencyScreen() {
        navController?.navigate(R.id.buttonLatencyTest)
    }

    private fun showLocalListItemsScreen() {
        navController?.navigate(R.id.listLocalItemsTest)
    }

    private fun showNetworkListItemsScreen() {
        navController?.navigate(R.id.listNetworkItemsTest)
    }

    private fun showComputationScreen() {
        navController?.navigate(R.id.computationTest)
    }

    private fun showVibrationLatencyScreen() {
        navController?.navigate(R.id.vibrationLatencyTest)
    }

    private fun showThirdPartyNoticesScreen() {
        navController?.navigate(R.id.thirdPartyNoticesScreen)
    }
}