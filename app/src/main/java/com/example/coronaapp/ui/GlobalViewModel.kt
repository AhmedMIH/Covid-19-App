package com.example.coronaapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coronaapp.network.CoronaApi
import com.example.coronaapp.network.AllCountries
import com.example.coronaapp.network.GlobalTotal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GlobalViewModel:ViewModel() {
    private val _response = MutableLiveData<GlobalTotal>()
    val response: LiveData<GlobalTotal>
        get() = _response

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData <Boolean>
    get() = _loading

    private val _countries = MutableLiveData<List<AllCountries>>()
    val countries: LiveData<List<AllCountries>>
        get() = _countries

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Main)

    init {
        getAllCases()
        getAllCountries()
    }


    private fun getAllCountries(){
        coroutineScope.launch {
            val getCountries = CoronaApi.RETROFIT_SERVICE.allCountries()
            try {
                val totalCases = getCountries.await()
                _countries.value = totalCases
                _loading.value = false
            }
            catch (e:Exception){
                _loading.value=true
            }
        }
    }
    private fun getAllCases() {
        coroutineScope.launch {
            val getCases = CoronaApi.RETROFIT_SERVICE.allCases()
            try {
                val totalCases = getCases.await()
                _response.value = totalCases
            }
            catch (e:Exception){

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}