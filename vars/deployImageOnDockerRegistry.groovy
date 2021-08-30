def call(String registryAddress, String registryName, String credentialsKey, String imageTag, String dockerFile, String, labelName, String, labelValue) {
  def dockerImage = null

  try {
      docker.withRegistry("${registryAddress}", "${credentialsKey}") {
          dockerImage = docker.build("${registryName}", "--file ${dockerFile} .")

          dockerImage.push('latest')
          dockerImage.push("${imageTag}")
      }
  } finally {
    if (dockerImage != null) {
        if (labelName != null && labelValue != null) {
            sh "docker image prune --filter label=${labelName}=${labelValue} --force"
        }

        def registryAddressWithoutHttp = "${registryAddress}".replace('http://', '')
        sh """
           docker image prune --filter label=${labelName}=${labelValue} --force
           docker rmi -f ${registryAddressWithoutHttp}${registryName}:${imageTag}
           docker rmi -f ${registryAddressWithoutHttp}${registryName}:latest
           """
    }
  }
}