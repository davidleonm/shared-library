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
       dotnet tool install --global --no-cache JetBrains.dotCover.GlobalTool ||
       dotnet tool update --global JetBrains.dotCover.GlobalTool
       """

    println('Cleaning and installing Codecov uploader')
    sh """
       rm --force ${CODECOV_PATH}
       curl --silent https://uploader.codecov.io/latest/linux/codecov --output ${CODECOV_PATH}
       chmod +x ${CODECOV_PATH}
       """
}