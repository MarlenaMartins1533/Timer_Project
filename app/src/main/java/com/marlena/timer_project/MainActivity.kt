package com.marlena.timer_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        tablayout.setupWithViewPager(viewPager)
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
//        initListeners()
    }

//    private fun initListeners() {
//        timerTAB?.setOnClickListener {
//            openFragment(TimerFragment())
//        }
//        stopWatchTAB?.setOnClickListener {
//            openFragment(TwoFragment())
//        }
//    }
//
//    private fun openFragment(fragment: Fragment) {
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.container, fragment)
//            .commit()
//    }
}
