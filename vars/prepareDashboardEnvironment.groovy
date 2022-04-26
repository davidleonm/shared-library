import com.davidleonm.WeatherStationDashboardVariables

def call() {
    println('Cleaning coverage report folder')
    sh "rm -rf ${COVERAGE_ROOT_FOLDER_PATH}"

    println('Cleaning and preparing node_modules ENV')
    sh """
       rm -rf ${REACT_ROOT_FOLDER}node_modules
       ( cd ${REACT_ROOT_FOLDER} && npm install )
       """

    println('Cleaning and installing Report generator uploader')
    sh """
       mkdir -p ${TOOLS_FOLDER}
       rm --force ${REPORT_GENERATOR_PATH}
       dotnet tool install --global dotnet-reportgenerator-globaltool
       """

    println('Cleaning and installing Codecov uploader')
    sh """
       mkdir -p ${TOOLS_FOLDER}
       rm --force ${CODECOV_PATH}
       curl --silent https://uploader.codecov.io/latest/linux/codecov --output ${CODECOV_PATH}
       chmod +x ${CODECOV_PATH}
       """
}