package com.pipo.bulksms.features.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.pipo.bulksms.R
import com.pipo.bulksms.features.base.BaseActivity
import com.pipo.bulksms.features.main.detail.DetailFragment
import com.pipo.bulksms.features.main.list.ListFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.main_layout.*

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:35 PM
 */
class MainActivity: BaseActivity<MainViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: MainViewModel

    private val  adapter: MainPagerAdpater by lazy { MainPagerAdpater(supportFragmentManager) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.let {sab ->
            sab.setDisplayHomeAsUpEnabled(true)
            sab.setDisplayHomeAsUpEnabled(true)

        }
        init()
    }


    private fun init(){
        adapter.addFragments(arrayOf(ListFragment.newInstance(), DetailFragment.newInstance()))
        adapter.tabTitles= resources.getStringArray(R.array.sms_job_tabs)
        viewPager.adapter= adapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
                //Do nothing
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
               //Do nothing
            }

            override fun onPageSelected(p0: Int) {
                title = adapter.tabTitles[p0]
            }

        })

        mViewModel.observeCurrentSmsJob(this.lifecycle){  navigateToFragment(1)}
    }

    private fun navigateToFragment(pagerPosition: Int) {
        viewPager.currentItem = pagerPosition

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {

        if(mViewModel.pagerPosition>0){
            mViewModel.pagerPosition--
            navigateToFragment(mViewModel.pagerPosition)
        }
        else{
            super.onBackPressed()
        }
    }




    override fun getViewModel(): MainViewModel {
        mViewModel= ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
        return mViewModel
    }

    override fun getLayoutId(): Int = R.layout.main_layout

}
