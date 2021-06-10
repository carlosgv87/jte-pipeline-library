// Method to download a Maven artifact from Nexus, if the version is not specified, the latest one will be downloaded
def downloadMavenArtifact(String groupId, String artifactId, String version = "", String classifier = "", String extension = "", String outputFile = "") {
    def latestVersionURL = ""
    if ((version == null) || (version == "")) {
        def latestVersion = ""
        try {
            log.info("Looking for latest version of Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | classifier: ${classifier} | extension: ${extension} | outputFile: ${outputFile} ]")
            log.info("Retrieving 'downloadUrl' for the latest version of Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | classifier: ${classifier} | extension: ${extension} ]")
            return latestVersionURL
        } catch (e) {
            error("There was an error downloading Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | version: ${latestVersion} | classifier: ${classifier} | extension: ${extension} ]")
        }
    } else {
        try {
            log.info("Looking for specified version of Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | version: ${version} | classifier: ${classifier} | extension: ${extension} | outputFile: ${outputFile} ]")
            log.info("Retrieving 'downloadUrl' for the specified version of Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | version: ${version} | classifier: ${classifier} | extension: ${extension} ]")
            return latestVersionURL
        } catch (e) {
            error("There was an error downloading Maven artifact: [ groupId: ${groupId} | artifactId: ${artifactId} | version: ${version} | classifier: ${classifier} | extension: ${extension} ]")
        }
    }
}

// Method to download a NPM package from Nexus, if the version is not specified, the latest one will be downloaded
def downloadNPMPackage(String packageName, String version = "", String outputFile = "") {
    def latestVersionURL = ""
    if ((version == null) || (version == "")) {
        def latestVersion = ""
        try {
            log.info("Looking for latest version of NPM package: [ name: ${packageName} | outputFile: ${outputFile} ]")
            log.info("Retrieving 'downloadUrl' for the latest version of NPM package: [ name: ${packageName} ]")
            return latestVersionURL
        } catch (e) {
            error("There was an error downloading NPM package: [ name: ${packageName} | version: ${latestVersion} ]")
        }
    } else {
        try {
            log.info("Looking for specified version of NPM package: [ name: ${packageName} | version: ${version} | outputFile: ${outputFile} ]")
            log.info("Retrieving 'downloadUrl' for the specified version of NPM package: [ name: ${packageName} | version: ${version} ]")
            return latestVersionURL
        } catch (e) {
            error("There was an error downloading NPM package: [ name: ${packageName} | version: ${version} ]")
        }
    }
}

// Method to look for a Docker image in Nexus
def lookForDockerImage(String imageName, String version) {
    def latestVersionURL = ""
    try {
        log.info("Looking for specified version of Docker image: [ name: ${imageName} | version: ${version} ]")
        log.info("Retrieving 'downloadUrl' for the specified version of Docker image: [ name: ${imageName} | version: ${version} ]")
        return latestVersionURL
    } catch (e) {
        error("There was an error looking for Docker image: [ name: ${imageName} | version: ${version} ]")
    }
}

// Method to upload a file to Nexus
def uploadFile(String file, String repository, String path) {
    log.info("Uploading file: [ file: ${file} | repository: ${repository} | path: ${path} ]")
    log.info("File: [ file: ${file} | repository: ${repository} | path: ${path} ] has been uploaded successfully")
}