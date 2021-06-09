boolean call(String appName) {
    boolean executeSonar = true
    def projectsWithoutSonar = ["project-without-sonar-1",
                                "project-without-sonar-2"]
    boolean skipSonarForProjects = appName in projectsWithoutSonar
    if (skipSonarForProjects) {
        executeSonar = false
    }
    return executeSonar
}