void call (String jenkinsCredentials, String organizationFolderName) {
    def jenkinsBaseURL = "https://jenkins.devtools.proyecto-sol.es"
    def timeToWaitBeforeLaunchingOrganizationFolderScan = 5
    log.info("Waiting ${timeToWaitBeforeLaunchingOrganizationFolderScan} minutes for Jenkins to refresh Bitbucket cache before launching 'Scan Organization Folder' over '${organizationFolderName}'")
    sleep(time: timeToWaitBeforeLaunchingOrganizationFolderScan, unit: 'MINUTES')
    log.info("Launching 'Scan Organization Folder' over '${organizationFolderName}'")
    httpRequest(authentication: jenkinsCredentials,
            consoleLogResponseBody: true,
            httpMode: 'POST',
            url: "${jenkinsBaseURL}/job/${organizationFolderName}/build?delay=0",
            validResponseCodes: '302')
    def timeToWaitUntilOrganizationFolderScanHasFinshed = 5
    log.info("Waiting ${timeToWaitUntilOrganizationFolderScanHasFinshed} minutes until Organization Folder Scan over '${organizationFolderName}' has finished")
    sleep(time: timeToWaitUntilOrganizationFolderScanHasFinshed, unit: 'MINUTES')
}