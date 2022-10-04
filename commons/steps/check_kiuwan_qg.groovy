void call(String appName) {
    def kiuwanAnalysisResultsOutputFileName = "kiuwan-analysis-results.json"
    httpRequest(authentication: 'kiuwan',
            consoleLogResponseBody: true,
            customHeaders: [[maskValue: false, name: 'X-KW-CORPORATE-DOMAIN-ID', value: '453e941ecc2081a15634656f5a1d460a17c8cf066bc9225651217d3226ceb8']],
            httpMode: 'GET',
            ignoreSslErrors: true,
            outputFile: kiuwanAnalysisResultsOutputFileName,
            url: "https://api.kiuwan.com/apps/${appName}",
            validResponseCodes: '200')
    def kiuwanAnalysisResultsOutputFileJSON = readJSON(file: kiuwanAnalysisResultsOutputFileName)

    def veryLowVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.VeryLow)
    def lowVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.Low)
    def normalVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.Normal)
    def highVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.High)
    def veryHighVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.VeryHigh)
    def totalVulnerabilities = Math.round(kiuwanAnalysisResultsOutputFileJSON.Security.Vulnerabilities.Total)

    echo """
    Analysis summary:
     - Security.Vulnerabilities.VeryLow: ${veryLowVulnerabilities}
     - Security.Vulnerabilities.Low: ${lowVulnerabilities}
     - Security.Vulnerabilities.Normal: ${normalVulnerabilities}
     - Security.Vulnerabilities.High: ${highVulnerabilities}
     - Security.Vulnerabilities.VeryHigh: ${veryHighVulnerabilities}
     - Security.Vulnerabilities.Total: ${totalVulnerabilities}
    Analysis result: ${kiuwanAnalysisResultsOutputFileJSON.analysisURL}"""

    def highVulnerabilitiesAllowed = 0
    def veryHighVulnerabilitiesAllowed = 0
    if ((highVulnerabilities > highVulnerabilitiesAllowed) || (veryHighVulnerabilities > veryHighVulnerabilitiesAllowed)) {
        error("Kiuwan Quality Gate has failed due to High or VeryHigh vulnerabilities have been found")
    }
}