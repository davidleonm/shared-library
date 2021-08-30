def call(boolean all, boolean force) {
    def command = 'docker image prune '

    if (all != null) {
        command = "${command} --all "
    }

    if (force != null) {
        command = "${command} --force"
    }

    sh "${command}"
}
