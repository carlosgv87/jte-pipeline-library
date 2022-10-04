void call() {
    if (currentBuild.rawBuild.getCauses().toString().contains("Branch")) {
        log.error("Build skipped due to it has been triggered by a branch event")
    }
}