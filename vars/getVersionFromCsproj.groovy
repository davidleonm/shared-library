def call(String filePath) {
    return (sh(script: "grep '<Version>' < ${filePath} | sed 's/.*<Version>\\(.*\\)<\\/Version>/\\1/'", returnStdout: true)).trim()
}