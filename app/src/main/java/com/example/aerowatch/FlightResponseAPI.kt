package com.example.aerowatch

data class FlightResponse(
    val data: List<FlightData>
)

data class FlightData(
    val flight_iata: String,
    val departure: Departure,
    val arrival: Arrival,
    val live: LiveData?
)

data class Departure(
    val airport: String,
    val scheduled: String,
    val actual: String
)

data class Arrival(
    val airport: String,
    val scheduled: String,
    val actual: String
)

data class LiveData(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val speed_horizontal: Double,
    val direction: Double
)
