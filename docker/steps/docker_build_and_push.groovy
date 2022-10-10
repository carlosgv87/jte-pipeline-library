void call(app_data) {
    docker_login()
    def buildYAMLFileName = "build.yaml"
    def versionFileName = "VERSION"
    def dockerBuilds = []
    if (fileExists(buildYAMLFileName)) {
        def buildData = readYaml(file: buildYAMLFileName)
        def builds = buildData['builds']
        builds.each { build ->
            dockerBuilds.add([
                    name     : build['name'] ?: app_data.repositoryName,
                    tag      : build['tag'] ?: currentBuild.number,
                    path     : build['path'],
                    buildArgs: build['args']
            ])
        }
    } else if (fileExists(versionFileName)) {
        def versionTag = sh(script: "head -n 1 ${versionFileName}", returnStdout: true).trim()
        dockerBuilds.add([
                name: app_data.repositoryName,
                tag : versionTag,
                path: '.'
        ])
    } else {
        dockerBuilds.add([
                name: app_data.repositoryName,
                tag : currentBuild.number,
                path: '.'
        ])
    }
    dockerBuilds.each { dockerBuild ->
        def imageTag = "${OB_REPO_DOCKER}/obkesp/${dockerBuild.name}:${dockerBuild.tag}"
        def deprecatedImageTag = "${OB_REPO_DOCKER}/${dockerBuild.name}:${dockerBuild.tag}"
        def extraBuildArgs = dockerBuild.buildArgs ? dockerBuild.buildArgs.collect { '--build-arg ' + it }.join(' ') : ''
        log.info("Building Docker image using Docker")
        //sh "docker build --build-arg OB_NPM_REGISTRY_TOKEN --build-arg OB_REPO_USER --build-arg OB_REPO_PASS ${extraBuildArgs} -t ${imageTag} -t ${deprecatedImageTag} ${dockerBuild.path}"
        //sh "docker push ${imageTag}"
        //sh "docker push ${deprecatedImageTag}"
    }
}