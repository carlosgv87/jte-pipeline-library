void call(body) {
    withMaven(globalMavenSettingsConfig: 'global-maven-settings', publisherStrategy: 'EXPLICIT') {
        withEnv(['DOCKER_HOST=tcp://localhost:2375']) {
            body()
        }
    }
}