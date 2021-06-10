String call(scm_data) {
    def pom = readMavenPom()
    return [
            "name"            : pom.artifactId,
            "version"         : pom.version,
            "nextFinalVersion": pom.version.endsWith("-SNAPSHOT") ? pom.version.replaceAll("-SNAPSHOT", ".${scm_data.GIT_COMMIT.take(7)}") : pom.version,
            "repositoryName"  : scm_data.GIT_URL.tokenize('/')[3].split("\\.")[0],
            "gitCommitHash"   : scm_data.GIT_COMMIT.take(7)
    ]
}