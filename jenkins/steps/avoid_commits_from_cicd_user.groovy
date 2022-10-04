void call() {
    def lastCommitAuthor = sh(script: "git log -1 --pretty=format:'%an'", returnStdout: true)
    log.info("Last commit author is: ${lastCommitAuthor}")
    def commitAuthorsToIgnore = ["orangebank-cicd"]
    if (lastCommitAuthor in commitAuthorsToIgnore) {
        log.error("Aborting execution due to last commit author is '${lastCommitAuthor}'")
    }
}