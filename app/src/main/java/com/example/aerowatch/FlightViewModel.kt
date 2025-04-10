package com.example.aerowatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlightViewModel : ViewModel() {

    private val _flightData = MutableLiveData<FlightData?>()
    val flightData: LiveData<FlightData?> get() = _flightData

    fun fetchFlightData(flightNumber: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.aviationstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val flightApiService = retrofit.create(FlightApiService::class.java)
        val apiKey = "34e33b5a0fcc389a04e0e162d52c317e"

        flightApiService.getFlightData(apiKey, flightNumber).enqueue(object : Callback<FlightResponse> {
            override fun onResponse(call: Call<FlightResponse>, response: Response<FlightResponse>) {
                if (response.isSuccessful) {
                    val flight = response.body()?.data?.firstOrNull()
                    if (flight != null) {
                        _flightData.postValue(flight)
                    } else {
                        _flightData.postValue(null)
                    }
                } else {
                    _flightData.postValue(null)
                }
            }

            override fun onFailure(call: Call<FlightResponse>, t: Throwable) {
                _flightData.postValue(null)
            }
        })
    }
}
