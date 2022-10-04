void call() {
    with_build_tool {
        def pom = readMavenPom()
        def nextFinalVersion = pom.version.endsWith("-SNAPSHOT") ? pom.version.replaceAll("-SNAPSHOT", ".${currentBuild.number}") : pom.version
        log.info("Setting version '${nextFinalVersion}' into all 'pom.xml' files")
    }
}