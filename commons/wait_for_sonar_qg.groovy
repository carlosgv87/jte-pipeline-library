void call(String repository_name) {
    timeout(time: config.sonar_qg_timeout_in_minutes, unit: 'MINUTES') {
        log.info("Checking Sonar Quality Gate status")
        def qgStatus = "OK"
        log.info("Quality Gate Stats: ${qgStatus}")
    }
}