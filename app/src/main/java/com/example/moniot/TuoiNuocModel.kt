package com.example.moniot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TuoiNuocModel:ViewModel() {
    private val _t1 = MutableLiveData<String>()
    val t1 : LiveData<String>
        get() = _t1
    private val _t2 = MutableLiveData<String>()
    val t2 : LiveData<String>
        get() = _t2
    private val _t3 = MutableLiveData<String>()
    val t3 : LiveData<String>
        get() = _t3
    private val _all = MutableLiveData<String>()
    val all : LiveData<String>
        get() = _all
    fun receiveT1(value:String){
        _t1.postValue(value)
    }
    fun receiveT2(value:String){
        _t2.postValue(value)
    }
    fun receiveT3(value:String){
        _t3.postValue(value)
    }
    fun receiveAll(value:String){
        _all.postValue(value)
    }
}