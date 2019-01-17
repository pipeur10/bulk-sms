package com.pipo.bulksms.features.main.list

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.pipo.bulksms.R
import com.pipo.bulksms.data.models.SmsJob
import com.pipo.bulksms.features.base.BaseFragment
import com.pipo.bulksms.features.main.MainActivity
import com.pipo.bulksms.features.main.MainViewModel
import kotlinx.android.synthetic.main.job_list_layout.*
import java.util.*
import javax.inject.Inject

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:49 PM
 */
class ListFragment: BaseFragment<ListViewModel>() {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: ListViewModel

    private lateinit var  sharedViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        if(activity is MainActivity){
            activity?.let {
                sharedViewModel= ViewModelProviders.of(it).get(MainViewModel::class.java)
            }
        }

        fabNew.setOnClickListener {
            sharedViewModel.postSmsJob(SmsJob(0, "", "", 0, 0, false, false, Date(), Date(), Date()))
        }
    }


    override fun getViewModel(): ListViewModel {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ListViewModel::class.java)
        return mViewModel
    }

    override fun getLayoutId(): Int = R.layout.job_list_layout


    companion object {
        fun  newInstance()= ListFragment()
    }
}