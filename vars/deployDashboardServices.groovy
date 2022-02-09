import com.davidleonm.WeatherStationDashboardVariables

def call(String registryAddress, String credentialsKey, String environment) {
    println('Deploy Client App')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.DashboardDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.App/WeatherStationProject.Dashboard.App.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=true --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.App --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy AirParametersService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.AirParametersServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.AirParametersService/WeatherStationProject.Dashboard.AirParametersService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.AirParametersService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy AmbientTemperatureService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.AmbientTemperatureServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.AmbientTemperatureService/WeatherStationProject.Dashboard.AmbientTemperatureService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.AmbientTemperatureService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy AuthenticationService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.AuthenticationServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.AuthenticationService/WeatherStationProject.Dashboard.AuthenticationService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.AuthenticationService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy GatewayService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.GatewayServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.GatewayService/WeatherStationProject.Dashboard.GatewayService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.GatewayService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy GroundTemperatureService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.GroundTemperatureServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.GroundTemperatureService/WeatherStationProject.Dashboard.GroundTemperatureService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.GroundTemperatureService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy RainfallService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.RainfallServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.RainfallService/WeatherStationProject.Dashboard.RainfallService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.RainfallService --build-arg ENVIRONMENT_ARG=${environment}")

    println('Deploy WindMeasurementsService')
    deployImageOnDockerRegistry("${registryAddress}",
                                "${WeatherStationDashboardVariables.WindMeasurementsServiceDockerRegistryName}",
                                "${credentialsKey}",
                                "${getVersionFromCsproj('./Code/src/WeatherStationProject.Dashboard.WindMeasurementsService/WeatherStationProject.Dashboard.WindMeasurementsService.csproj')}",
                                './Dockerfile',
                                "--build-arg INCLUDE_NPM_ARG=false --build-arg PROJECT_NAME_ARG=WeatherStationProject.Dashboard.WindMeasurementsService --build-arg ENVIRONMENT_ARG=${environment}")
}