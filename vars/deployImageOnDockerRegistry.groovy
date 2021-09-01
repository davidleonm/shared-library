def call(String registryAddress, String registryName, String credentialsKey, String imageTag, String dockerFile, String buildArgs) {
    def dockerImage = null

    try {
        docker.withRegistry("${registryAddress}", "${credentialsKey}") {
            dockerImage = docker.build("${registryName}", "${buildArgs} --file ${dockerFile} .")

            dockerImage.push('latest')
            dockerImage.push("${imageTag}")
        }
    } finally {
        if (dockerImage != null) {
            def registryAddressWithoutHttp = "${registryAddress}".replace('http://', '').replace('https://', '')

            if (registryAddressWithoutHttp != '') {
                sh """
                   docker rmi --force ${registryAddressWithoutHttp}${registryName}:${imageTag}
                   docker rmi --force ${registryAddressWithoutHttp}${registryName}:latest
                   """
            }

            sh """
               docker rmi --force ${registryName}:${imageTag} || true
               docker rmi --force ${registryName}:latest || true
               """
        }
    }
}
