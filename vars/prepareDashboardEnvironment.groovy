import com.davidleonm.WeatherStationDashboardVariables

def call() {
    println('Cleaning coverage report folder')
    sh "rm -rf ${WeatherStationDashboardVariables.ReactRootFolder}/coverage"

    println('Cleaning and preparing node_modules ENV')
    sh """
       rm -rf ${WeatherStationDashboardVariables.ReactRootFolder}/node_modules
       ( cd ${WeatherStationDashboardVariables.ReactRootFolder} && npm install )
       """

    println('Cleaning and installing dotCover')
    sh """
       rm -rf ${WeatherStationDashboardVariables.ToolsFolder}
       dotnet tool install JetBrains.dotCover.GlobalTool --no-cache --tool-path ${WeatherStationDashboardVariables.ToolsFolder}
       """
}