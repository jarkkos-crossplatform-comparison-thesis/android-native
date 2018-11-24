package fi.jara.thesis.thesisnative

import android.view.MotionEvent
import android.view.View

fun View.setOnTouchDownListener(listener: ((view: View, motionEvent: MotionEvent) -> Unit)?) {
    if (listener != null) {
        setOnTouchListener { v, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                listener(v, event)
            }

            return@setOnTouchListener false
        }
    } else {
        setOnTouchListener(null)
    }
}