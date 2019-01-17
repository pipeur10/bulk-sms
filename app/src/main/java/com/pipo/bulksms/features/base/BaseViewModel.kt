package com.pipo.bible.features.base

import android.arch.lifecycle.ViewModel
import com.pipo.bulksms.data.repository.LocalRepository

/**
 * Author: Philip
 * Date: 27/07/2018 at 12:10 PM
 */
open class BaseViewModel<N>(val localRepository: LocalRepository) : ViewModel() {
    var  mNavigator: N? = null


}