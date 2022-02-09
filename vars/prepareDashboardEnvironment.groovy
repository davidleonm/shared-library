import com.davidleonm.WeatherStationDashboardVariables

def call() {
    println('Cleaning coverage report folder')
    sh "rm -rf ${REACT_ROOT_FOLDER}/coverage"

    println('Cleaning and preparing node_modules ENV')
    sh """
       rm -rf ${REACT_ROOT_FOLDER}/node_modules
       ( cd ${REACT_ROOT_FOLDER} && npm install )
       """

    println('Cleaning and installing dotCover')
    sh """
       rm -rf ${TOOLS_FOLDER}
       dotnet tool install JetBrains.dotCover.GlobalTool --no-cache --tool-path ${TOOLS_FOLDER}
       """
}