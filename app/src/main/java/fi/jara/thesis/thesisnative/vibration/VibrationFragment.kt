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
import kotlinx.android.synthetic.main.button_async_result.*

class VibrationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.button_and_state, container, false)
        view.findViewById<TextView>(R.id.report_test_state_text).visibility = View.GONE

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        do_action_button.setOnClickListener { vibrateDevice() }

        /*
        TODO define in docs what type of click listener should be used:
        - tool default
        - always react to touch/click start
        - always react to touch/click end
        do_action_button.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                vibrateDevice()
            }

            false
        }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        do_action_button.setOnClickListener(null)
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