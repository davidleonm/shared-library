def call(String registryAddress, String registryName, String credentialsKey, String imageTag, String dockerfile) {
  def dockerImage = null

  try {
    dockerImage = docker.build("${registryName}", "--file ./Dockerfile ${dockerfile}")

    docker.withRegistry("${registryAddress}", "${credentialsKey}") {
      dockerImage.push('latest')
      dockerImage.push("${imageTag}")
    }
  } finally {
    if (dockerImage != null) {
      sh """
         docker rmi -f ${registryName}:${imageTag}
         docker rmi -f ${registryName}:latest
         """
    }
  }
}