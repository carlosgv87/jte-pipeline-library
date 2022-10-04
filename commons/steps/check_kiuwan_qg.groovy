void call(String appName) {
    def veryLowVulnerabilities = 0
    def lowVulnerabilities = 0
    def normalVulnerabilities = 0
    def highVulnerabilities = 0
    def veryHighVulnerabilities = 0
    def totalVulnerabilities = 0

    echo """
    Analysis summary:
     - Security.Vulnerabilities.VeryLow: ${veryLowVulnerabilities}
     - Security.Vulnerabilities.Low: ${lowVulnerabilities}
     - Security.Vulnerabilities.Normal: ${normalVulnerabilities}
     - Security.Vulnerabilities.High: ${highVulnerabilities}
     - Security.Vulnerabilities.VeryHigh: ${veryHighVulnerabilities}
     - Security.Vulnerabilities.Total: ${totalVulnerabilities}
    """
}