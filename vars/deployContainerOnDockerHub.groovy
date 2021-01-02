def call(String dockerHubRegistryName) {
  def dockerImage = null

  try {
    tag = sh(script: 'cat VERSION', returnStdout: true)
    dockerImage = docker.build("${dockerHubRegistryName}", "--file ./Dockerfile ${WORKSPACE}")

    docker.withRegistry('', 'docker-hub-login') {
      dockerImage.push('latest')
      dockerImage.push("${tag}")
    }
  } finally {
    if (dockerImage != null) {
      sh """
         docker rmi -f ${dockerHubRegistryName}:${tag}
         docker rmi -f ${dockerHubRegistryName}:latest
         """
    }
  }
}