package com.pipo.bulksms.features.main.detail

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.pipo.bulksms.R
import com.pipo.bulksms.features.base.BaseFragment
import javax.inject.Inject

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:49 PM
 */
class DetailFragment: BaseFragment<DetailViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: DetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init(){

    }


    override fun getViewModel(): DetailViewModel {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(DetailViewModel::class.java)
        return mViewModel
    }

    override fun getLayoutId(): Int = R.layout.job_detail_layout


    companion object {
        fun  newInstance()= DetailFragment()
    }
}