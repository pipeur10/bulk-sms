package com.pipo.bulksms.features.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.pipo.bible.features.base.BaseViewModel
import com.pipo.bulksms.features.base.BaseFragment

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:39 PM
 */
class MainPagerAdpater(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    private var listFragment: Array<BaseFragment<out BaseViewModel<out Any>>?>? = null
    var tabTitles: Array<String> = arrayOf()

    override fun getItem(position: Int): Fragment {
        listFragment?.let { lst ->
            lst[position]?.let { return it }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        listFragment?.let {lst -> return lst.size }
        return 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(tabTitles.isEmpty()){
            return  super.getPageTitle(position)
        }
        return tabTitles[position]
    }

    fun addFragments(fragments: Array<BaseFragment<out BaseViewModel<out Any>>?>){
        listFragment= fragments
    }
}