package com.marlena.timer_project

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_timer.*

class TimerFragment : Fragment() {

    private var param: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        param = arguments?.getString(TYPE_PARAM)
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private var isRunning = false
    private fun initListener(){

        chronometer_timer.base = SystemClock.elapsedRealtime()

        b_timer_start.setOnClickListener {
            when (isRunning) {
                false -> {
                    chronometer_timer.base = SystemClock.elapsedRealtime()
                    chronometer_timer.start()
                    if (param == STOP_WATCH_PARAM) b_timer_start.setText(R.string.stop)
                    isRunning = true
                }
                true -> {
                    if (param == TIMER_PARAM) {
                        chronometer_timer.base = SystemClock.elapsedRealtime()
                        chronometer_timer.start()
                    } else if (param == STOP_WATCH_PARAM){
                        chronometer_timer.stop()
                        b_timer_start.setText(R.string.start)
                        isRunning = false
                    }
                }
            }
        }
    }

    companion object {
        const val TIMER_PARAM = "timer_param"
        const val STOP_WATCH_PARAM = "stop_watch_param"

        private const val TYPE_PARAM = "type_param"

        fun newInstance(param: String) =
            TimerFragment().apply {
                arguments = Bundle().apply {
                    putString(TYPE_PARAM, param)
                }
            }
    }
}