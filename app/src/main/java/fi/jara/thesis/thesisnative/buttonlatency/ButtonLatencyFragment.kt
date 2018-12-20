package fi.jara.thesis.thesisnative.buttonlatency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.setOnTouchDownListener
import kotlinx.android.synthetic.main.button_latency.*

class ButtonLatencyFragment: Fragment() {
    private var numBtnClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        numBtnClicked = savedInstanceState?.getInt(EXTRA_NUM_BUTTON_CLICKED, 0) ?: 0
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.button_latency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counter_text.text = numBtnClicked.toString()

        increment_counter_button.setOnTouchDownListener { _, _ ->
            incrementCounter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        increment_counter_button.setOnClickListener(null)
    }

    private fun incrementCounter() {
        numBtnClicked++
        counter_text.text = numBtnClicked.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_NUM_BUTTON_CLICKED, numBtnClicked)
    }

    companion object {
        const val EXTRA_NUM_BUTTON_CLICKED = "num_btn_clicked"
    }
}