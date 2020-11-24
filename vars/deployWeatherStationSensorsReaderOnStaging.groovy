import com.davidleonm.WeatherStationSensorsReaderVariables

def call() {
  def dockerImage = null

  try {
    dockerImage = docker.build("${WeatherStationSensorsReaderVariables.DockerHubStagingRegistryName}", "--file ./Dockerfile ${WORKSPACE}")

    docker.withRegistry('', 'docker-hub-login') {
      dockerImage.push("${BUILD_ID}")
      dockerImage.push('latest')
    }
  } finally {
    if (dockerImage != null) {
      sh """
         docker rmi -f ${WeatherStationSensorsReaderVariables.DockerHubStagingRegistryName}:${BUILD_ID}
         docker rmi -f ${WeatherStationSensorsReaderVariables.DockerHubStagingRegistryName}:latest
         """
    }
  }
}