void call(name) {
    dir('chart') {
        def fileName = "Chart.yaml"
        if (!fileExists(fileName)) {
            def chartFileContent = """
apiVersion: v1
description: A Helm chart for Kubernetes
name: ${name}
version: 0.1.0
"""
            writeFile(file: fileName, text: chartFileContent)
            log.info(chartFileContent)
        } else {
            log.info("Custom '${fileName}' file present in ops repository")
        }
    }
}