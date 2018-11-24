package fi.jara.thesis.thesisnative.vibration

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.setOnTouchDownListener
import kotlinx.android.synthetic.main.button_async_result.*

class VibrationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.button_and_state, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        report_test_state_text.visibility = View.GONE

        do_action_button.setOnTouchDownListener { _, _ ->
            vibrateDevice()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        do_action_button.setOnTouchDownListener(null)
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