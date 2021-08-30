def call(String registryAddress, String registryName, String credentialsKey, String imageTag, String dockerFile) {
    def dockerImage = null

    try {
        docker.withRegistry("${registryAddress}", "${credentialsKey}") {
            dockerImage = docker.build("${registryName}", "--file ${dockerFile} .")

            dockerImage.push('latest')
            dockerImage.push("${imageTag}")
        }
    } finally {
        if (dockerImage != null) {
            def registryAddressWithoutHttp = "${registryAddress}".replace('http://', '').replace('https://', '')

            sh """
                docker rmi -f ${registryAddressWithoutHttp}${registryName}:${imageTag}
                docker rmi -f ${registryAddressWithoutHttp}${registryName}:latest
                """
        }
    }
}
