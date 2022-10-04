void call(String user, String password, String appName, String kiuwanExcludesPattern, String kiuwanIncludesPattern) {
    timeout(time: 1, unit: 'MINUTES') {
        log.info("Executing Kiuwan analysis")
    }
}