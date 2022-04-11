package com.kangmin.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    protected val _toastMsg = MutableLiveData<String>()
    val toastMsg: LiveData<String> = _toastMsg

}