package com.davidleonm

import com.davidleonm.GlobalVariables

class PythonHelloWorldVariables {
  static String RepositoryName = 'python-hello-world'
  static String DockerHubRegistryName = 'davidleonm/pythonhelloworld'

  // The Jenkins server is the host of the environment so the URL for CI request is the same but different port
  static String ContinuousIntegrationUrl = "${JENKINS_URL}".replace('8080/', '9999')
  static String ContinuousIntegrationForbiddenAnswer = 'Forbidden site!'
  static String ContinuousIntegrationAllowedAnswer = 'Hello World!'
}