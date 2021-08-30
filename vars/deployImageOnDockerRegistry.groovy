def call(String registryAddress, String registryName, String credentialsKey, String imageTag, String dockerFile, String labelName, String labelValue) {
  def dockerImage = null

  try {
      docker.withRegistry("${registryAddress}", "${credentialsKey}") {
          dockerImage = docker.build("${registryName}", "--file ${dockerFile} .")

          dockerImage.push('latest')
          dockerImage.push("${imageTag}")
      }
  } finally {
    if (dockerImage != null) {
        sh "docker image prune --filter label=${labelName}=${labelValue} --force"
    }
  }
}