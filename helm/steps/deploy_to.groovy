void call(k8sCredentialsId, envShortName, helm_chart = null, helm_global_values = null, String appName, String namespace = "") {
    log.debug("K8s credentials used: ${k8sCredentialsId}")
    def cartFolderName = "chart/"
    def chartFolderExists = false
    if (fileExists(cartFolderName)) {
        chartFolderExists = true
    }
    def isACustomHelmChart = (chartFolderExists || ((helm_chart == null) && (helm_global_values == null)))
    if (!isACustomHelmChart) {
        log.info("This is an standard batch/microservice and its Helm requirements will be injected from global pipeline configuration")
        log.debug("Helm chart used: ${helm_chart}")
        log.debug("Helm global values used: ${helm_global_values}")
        create_requirements_file(helm_chart, helm_global_values)
        create_chart_file(appName)
    } else {
        log.info("This repository contains a custom Helm chart or a batch/microservice with specific Helm requirements")
    }
    sh "ls -la"
    sh "ls -la ${cartFolderName}"
    dir(cartFolderName) {
        sh "cat Chart.yaml"
        sh "cat requirements.yaml"
    }
    log.debug("NAMESPACE: ${namespace}")
    log.debug("APP NAME: ${appName}")
    sh "cat releases/${envShortName}.yaml"
    log.info("Deploying '${appName}'")
}