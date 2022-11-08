package com.davidleonm

class GlobalVariables {
  // Github credentials token key
  static String GitHubToken = 'github-token'

  // PROD Docker registry credentials key
  static String ProductionCredentialsDockerRegistryKey = 'docker-hub-login'

  // STAGING Docker registry credentials key
  static String StagingCredentialsDockerRegistryKey = 'docker-registry-login'

  // STAGING Docker registry address
  static String StagingDockerRegistry = 'http://192.168.1.69:31050/'
}
