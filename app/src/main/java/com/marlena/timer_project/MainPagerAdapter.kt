package com.marlena.timer_project

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter (fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentList = arrayListOf<Fragment>() //Lista dos Fragmentos
    private val titleList = arrayListOf<String>()//Lista dos nomes dos Fragmentos

    init{
        titleList.add("Timer")
        titleList.add("Stopwatch")
        fragmentList.add(TimerFragment())
        fragmentList.add(StopWatchFragment())
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]

}