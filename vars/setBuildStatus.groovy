import com.davidleonm.GlobalVariables

def call(String status, String repoName) {
  withCredentials([string(credentialsId: "${GlobalVariables.GitHubToken}", variable: 'GITHUB_TOKEN')]) {
    sh 'curl -s -k -H \'Authorization: Bearer ${GITHUB_TOKEN}\' \
      -H \'Content-Type: application/json\' \
      -X POST \'https://api.github.com/repos/davidleonm/${repoName}/statuses/${GIT_COMMIT}\' \
      -d \'{\"state\": \"${status}\",\"context\": \"continuous-integration/jenkins\", \"description\": \"Jenkins\", \"target_url\": \"${BUILD_URL}\"}\''
  }
}