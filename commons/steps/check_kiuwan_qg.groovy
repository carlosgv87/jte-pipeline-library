void call(String appName) {
    echo """
    Analysis summary:
     - Security.Vulnerabilities.VeryLow: ${veryLowVulnerabilities}
     - Security.Vulnerabilities.Low: ${lowVulnerabilities}
     - Security.Vulnerabilities.Normal: ${normalVulnerabilities}
     - Security.Vulnerabilities.High: ${highVulnerabilities}
     - Security.Vulnerabilities.VeryHigh: ${veryHighVulnerabilities}
     - Security.Vulnerabilities.Total: ${totalVulnerabilities}
    Analysis result: ${kiuwanAnalysisResultsOutputFileJSON.analysisURL}"""
}