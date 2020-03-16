import com.davidleonm.PythonHelloWorldVariables

def call() {
  def dockerImage = null
  def ciImageName = "python-hello-world-ci-image-${this.env.BUILD_ID}"

  try {
    dockerImage = docker.build("${ciImageName}", "--file ./Dockerfile ${this.env.WORKSPACE}")

    dockerImage.withRun("-p 9999:9999 --name=${ciImageName} -d") {
      forbiddenResponse = sh(script: "curl ${PythonHelloWorldVariables.ContinuousIntegrationUrl}", returnStdout: true)
      helloWorldResponse = sh(script: "curl ${PythonHelloWorldVariables.ContinuousIntegrationUrl}/helloworld", returnStdout: true)

      if (forbiddenResponse != "${PythonHelloWorldVariables.ContinuousIntegrationForbiddenAnswer}" || \
          helloWorldResponse != "${PythonHelloWorldVariables.ContinuousIntegrationAllowedAnswer}") {
        currentBuild.result = 'FAILURE'
        throw new Exception('Error in CI, got non-expected values')
      }
    }
  } finally {
    if (dockerImage != null) {
      sh "docker rmi -f ${ciImageName}"
    }
  }
}