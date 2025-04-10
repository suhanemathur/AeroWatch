# AeroWatch - Flight Tracking & Analytics

A Jetpack Compose Android application that provides real-time flight tracking and historical flight time analytics.

## Features

### Task 1: Real-Time Flight Tracking
- Track flights using IATA flight numbers
- View live aircraft position (latitude/longitude)
- Display departure and arrival information:
  - Airport names and codes
  - Scheduled vs actual times
  - Current delays

### Task 2: Flight Time Analytics
- Automatic background data collection:
  - 3 flights per day tracked for specified routes
  - Delay information incorporated
- Weekly average time calculation
- Room database storage for:
  - Historical flight data
  - Calculated averages
- WorkManager-powered background processing
