package fi.jara.thesis.thesisnative.vibration

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.setOnTouchDownListener
import kotlinx.android.synthetic.main.vibration_latency.*

class VibrationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vibration_latency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vibrate_button.setOnTouchDownListener { _, _ ->
            vibrateDevice()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        vibrate_button.setOnTouchDownListener(null)
    }

    private fun vibrateDevice() {
        val vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE))
        }
        else {
            vibrator.vibrate(400)
        }
    }
}