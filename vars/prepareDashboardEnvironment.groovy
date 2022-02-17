import com.davidleonm.WeatherStationDashboardVariables

def call() {
    println('Cleaning coverage report folder')
    sh "rm -rf ${REACT_ROOT_FOLDER}/coverage"

    println('Cleaning and preparing node_modules ENV')
    sh """
       rm -rf ${REACT_ROOT_FOLDER}/node_modules
       ( cd ${REACT_ROOT_FOLDER} && npm install )
       """

    println('Cleaning and installing coverlet')
    sh """
       dotnet tool install --global --no-cache coverlet.console ||
       dotnet tool update --global coverlet.console
       """

    println('Cleaning and installing Codecov uploader')
    sh """
       rm --force ${CODECOV_PATH}
       curl --silent https://uploader.codecov.io/latest/linux/codecov --output ${CODECOV_PATH}
       chmod +x ${CODECOV_PATH}
       """
}