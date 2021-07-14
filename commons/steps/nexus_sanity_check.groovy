void call(String operation, String pipelineType, app_data, repository_data) {
    def errorMessage = ""
    def errorMessageMKD = ""
    def versionToDeploy = ""
    switch (pipelineType) {
        case 'microservice':
            versionToDeploy = app_data.version
            def dockerImage = app_data.image
            def dockerImageFullName = "${dockerImage}:${app_data.version}"
            def dockerImageDownloadURL = nexus.lookForDockerImage(dockerImage, versionToDeploy)
            if (dockerImageDownloadURL == null) {
                errorMessage = "Nexus Sanity Check has FAILED because Docker image '${dockerImageFullName}' IS NOT PRESENT in Nexus. Please check in Jenkins if the '${dockerImage}' job which should have published version '${versionToDeploy}' to Nexus has finished successfully"
                errorMessageMKD = "**Nexus Sanity Check has FAILED**:  \n - Docker image **'${dockerImageFullName}' IS NOT PRESENT in Nexus**.  \n - Please **check in Jenkins if the '${dockerImage}' job which should have published version '${versionToDeploy}' to Nexus has finished successfully**"
            }
            break
        case 'webapp':
            def packageName = app_data.name
            versionToDeploy = app_data.version
            def npmPackageFullName = "${packageName}-${versionToDeploy}.tgz"
            def npmPackageDownloadURL = nexus.downloadNPMPackage(packageName, versionToDeploy, npmPackageFullName)
            if (npmPackageDownloadURL == null) {
                errorMessage = "Nexus Sanity Check has FAILED because NPM package '${npmPackageFullName}' IS NOT PRESENT in Nexus. Please check in Jenkins if the '${packageName}' job which should have published version '${versionToDeploy}' to Nexus has finished successfully"
                errorMessageMKD = "**Nexus Sanity Check has FAILED**:  \n - NPM package **'${npmPackageFullName}' IS NOT PRESENT in Nexus**.  \n - Please **check in Jenkins if the '${packageName}' job which should have published version '${versionToDeploy}' to Nexus has finished successfully**"
            }
            break
        default:
            log.info("Nexus sanity check isn't yet implemented for '${pipelineType}' deployment pipeline")
    }
    if ((errorMessage != "") && (errorMessageMKD != "")) {
        if ("PR".equalsIgnoreCase(operation)) {
            report(repository_data, errorMessageMKD)
        }
        log.error(errorMessage)
    }
}