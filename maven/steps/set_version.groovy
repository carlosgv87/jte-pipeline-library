void call(app_data) {
    def nextFinalVersion = app_data.nextFinalVersion
    log.info("Setting version '${nextFinalVersion}' into all 'pom.xml' files")
}