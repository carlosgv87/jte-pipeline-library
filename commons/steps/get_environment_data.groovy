Object call(String environment_name) {
    log.debug(binding)
    log.debug(binding.variables)
    log.debug(binding.toString())
    log.debug(binding.getProperties())
    return binding.getVariable(environment_name)
}