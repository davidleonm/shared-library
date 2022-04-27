import com.davidleonm.WeatherStationDashboardVariables

def call() {
    println('Cleaning coverage report folder')
    sh "rm -rf ${COVERAGE_ROOT_FOLDER_PATH}"

    println('Cleaning and preparing node_modules ENV')
    sh """
       rm -rf ${REACT_ROOT_FOLDER}node_modules
       ( cd ${REACT_ROOT_FOLDER} && npm install )
       """

    println('Installing coveralls')
    sh 'dotnet tool install --global coveralls.net || dotnet tool update --global coveralls.net'
}