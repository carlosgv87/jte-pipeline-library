void call(env_data, app_data, error) {
    def message = """
    #### ${currentBuild.currentResult} - ${env_data.short_name.toUpperCase()} ${app_data.name} ${app_data.version} ####
    ${error}"""
    log.info("NOTIFICATION")
    //office365ConnectorSend(message: message, webhookUrl: env_data.office365_webhook_url, status: currentBuild.currentResult)
}