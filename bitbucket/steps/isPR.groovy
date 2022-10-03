Boolean call() {
    log.debug("isPR")
    return env.CHANGE_ID != null
}