package com.example.aerowatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aerowatch.ui.theme.AeroWatchTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AeroWatchTheme {
                val viewModel: FlightViewModel = viewModel()
                FlightTrackingUI(viewModel)
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FlightTrackingUI(viewModel: FlightViewModel) {
        var flightNumber = TextFieldValue("")

        val flightData by viewModel.flightData.observeAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = flightNumber,
                onValueChange = { flightNumber = it },
                label = { Text("Enter Flight Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.fetchFlightData(flightNumber.text)
            }) {
                Text(text = "Track Flight")
            }

            Spacer(modifier = Modifier.height(16.dp))

            flightData?.let { flight ->
                Text("Flight Number: ${flight.flight_iata}")
                Text("Departure Airport: ${flight.departure.airport}")
                Text("Arrival Airport: ${flight.arrival.airport}")
                Text("Current Latitude: ${flight.live?.latitude}")
                Text("Current Longitude: ${flight.live?.longitude}")
            }

            if (flightData == null) {
                Text("No flight data available.")
            }
        }
    }
}
