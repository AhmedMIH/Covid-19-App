package com.example.coronaapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {
    private val _response = MutableLiveData<GlobalTotal>()
    val response: LiveData<GlobalTotal>
        get() = _response

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
                Log.d("apiSuccess",_countries.value.toString())
            }
            catch (e:Exception){
                Log.d("api","error")
                print("Error")
            }
        }
    }
    private fun getAllCases() {
        coroutineScope.launch {
            val getCases = CoronaApi.RETROFIT_SERVICE.allCases()
            try {
                val totalCases = getCases.await()
                _response.value = totalCases
                Log.d("apiSuccess",_response.value.toString())
            }
            catch (e:Exception){
                Log.d("api","error")
                print("Error")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}