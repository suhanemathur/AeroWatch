package com.example.aerowatch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlightApiService {
    @GET("v1/flights")
    fun getFlightData(
        @Query("access_key") apiKey: String,
        @Query("flight_iata") flightNumber: String
    ): Call<FlightResponse>
}
