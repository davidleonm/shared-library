package com.davidleonm

import com.davidleonm.GlobalVariables

class WeatherStationDashboardVariables {
    // Github repository name
    static String RepositoryName = 'weather-station-project/dashboard'

    // Registry name in Docker registry to push the image for the Dashboard
    static String DashboardDockerRegistryName = 'weatherstationproject/dashboard'

    // Registry name in Docker registry to push the image for the AirParametersService
    static String AirParametersServiceDockerRegistryName = 'weatherstationproject/air-parameter-service'

    // Registry name in Docker registry to push the image for the AmbientTemperatureService
    static String AmbientTemperatureServiceDockerRegistryName = 'weatherstationproject/ambient-temperature-service'

    // Registry name in Docker registry to push the image for the AuthenticationService
    static String AuthenticationServiceDockerRegistryName = 'weatherstationproject/authentication-service'

    // Registry name in Docker registry to push the image for the GatewayService
    static String GatewayServiceDockerRegistryName = 'weatherstationproject/gateway-service'

    // Registry name in Docker registry to push the image for the GroundTemperatureService
    static String GroundTemperatureServiceDockerRegistryName = 'weatherstationproject/ground-temperature-service'

    // Registry name in Docker registry to push the image for the RainfallService
    static String RainfallServiceDockerRegistryName = 'weatherstationproject/rainfall-service'

    // Registry name in Docker registry to push the image for the WindMeasurementsService
    static String WindMeasurementsServiceDockerRegistryName = 'weatherstationproject/wind-measurements-service'
}
