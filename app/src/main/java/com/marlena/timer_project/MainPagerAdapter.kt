package com.marlena.timer_project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.marlena.timer_project.TimerFragment.Companion.STOP_WATCH_PARAM
import com.marlena.timer_project.TimerFragment.Companion.TIMER_PARAM

class MainPagerAdapter (fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentList = arrayListOf<Fragment>() //Lista dos Fragmentos
    private val titleList = arrayListOf<String>()//Lista dos nomes dos Fragmentos

    init{
        titleList.add("Timer")
        titleList.add("Stopwatch")
        fragmentList.add(TimerFragment.newInstance(TIMER_PARAM))
        fragmentList.add(TimerFragment.newInstance(STOP_WATCH_PARAM))
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}