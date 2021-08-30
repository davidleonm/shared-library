def call(boolean all, boolean force) {
    def command = 'docker image prune '

    if (all) {
        command = "${command} --all "
    }

    if (force) {
        command = "${command} --force"
    }

    sh "${command}"
}
