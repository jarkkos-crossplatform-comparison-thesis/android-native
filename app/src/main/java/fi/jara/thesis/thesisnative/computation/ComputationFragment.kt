package fi.jara.thesis.thesisnative.computation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.R
import fi.jara.thesis.thesisnative.setOnTouchDownListener
import kotlinx.android.synthetic.main.button_async_result.*
import kotlinx.coroutines.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.sqrt

class ComputationFragment : Fragment() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var asyncComputationJob: Job? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.button_async_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        do_action_button.setOnTouchDownListener { _, _ ->
            startAsyncOperation()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        asyncComputationJob?.cancel()
        do_action_button.setOnTouchDownListener(null)
    }

    private fun startAsyncOperation() {
        progressbar.visibility = View.VISIBLE
        report_test_state_text.setText(R.string.test_state_computing)

        asyncComputationJob?.cancel()
        asyncComputationJob = coroutineScope.launch {
            val primes = async(Dispatchers.Default) { findPrimesBelow(3_000_000) }.await()

            progressbar.visibility = View.GONE
            report_test_state_text.setText(R.string.test_state_done)
        }
    }

    private fun findPrimesBelow(number: Int): List<Int> {
        fun isPrimeNumber(number: Int): Boolean {
            if (number == 1) {
                return false
            }

            if (number == 2) {
                return true
            }

            val sqrt = sqrt(number.toDouble())
            val sqrtLng = sqrt.roundToInt()
            for (i: Int in 2..sqrtLng) {
                if (number % i == 0) {
                    return false
                }
            }

            return true
        }

        val primes = mutableListOf<Int>()
        for (i: Int in 1 until number) {
            if (isPrimeNumber(i)) {
                primes.add(i)
            }
        }

        return primes
    }
}