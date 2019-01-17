package com.pipo.bulksms.features.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.pipo.bible.features.base.BaseViewModel
import com.pipo.bulksms.data.models.SmsJob
import com.pipo.bulksms.data.repository.LocalRepository

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:37 PM
 */
class MainViewModel(localRepository: LocalRepository): BaseViewModel<MainNavigator>(localRepository) {
    var pagerPosition=0

    private val currentJobLIveData= MutableLiveData<SmsJob>()


    fun postSmsJob(job: SmsJob){
        currentJobLIveData.postValue(job)
    }

    fun observeCurrentSmsJob(lifecycle: Lifecycle, observer: (SmsJob) -> Unit){
        currentJobLIveData.observe({lifecycle}){ job -> job?.let(observer)}
    }
}
