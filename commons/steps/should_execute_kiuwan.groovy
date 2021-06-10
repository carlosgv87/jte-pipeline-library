boolean call(String appName) {
    boolean executeKiuwan = true
    // Maven projects
    def mavenProjectsWithoutKiuwan = ["project-without-kiuwan-1",
                                      "project-without-kiuwan-1"]
    boolean skipKiuwanForMavenProject = appName in mavenProjectsWithoutKiuwan
    // NPM projects
    boolean isNpmProject = fileExists("package.json")
    if (isNpmProject || skipKiuwanForMavenProject) {
        executeKiuwan = false
    }
    return executeKiuwan
}