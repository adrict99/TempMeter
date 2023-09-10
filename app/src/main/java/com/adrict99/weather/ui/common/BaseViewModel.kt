package com.adrict99.weather.ui.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    companion object {
        const val SHOW = true
        const val DISMISS = false
    }

    val loading : MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>().apply { value = false } }

    val errorMessage: MutableLiveData<Map<Int, String>> by lazy { MutableLiveData<Map<Int, String>>() }

}