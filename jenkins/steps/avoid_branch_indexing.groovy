void call() {
    if (currentBuild.rawBuild.getCauses().toString().contains("BranchIndexingCause")) {
        log.error("Build skipped due to it has been triggered by a branch indexing event")
    }
}