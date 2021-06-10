void call(helm_chart, helm_global_values) {
    dir('chart') {
        def fileName = "requirements.yaml"
        if (!fileExists(fileName)) {
            def requirementsFileContent = """
dependencies:
  - name: ${helm_chart.name}
    version: ${helm_chart.version}
    repository: 's3://obkesp-devtools-helm-charts'
  - name: ${helm_global_values.name}
    version: ${helm_global_values.version}
    repository: 's3://obkesp-devtools-helm-charts'
    import-values:
      - data
"""
            writeFile(file: fileName, text: requirementsFileContent)
            log.info(requirementsFileContent)
        } else {
            log.info("Custom '${fileName}' present in ops repository")
        }
    }
}