Object call(String environment_name) {
    log.debug(binding)
    log.debug(binding.variables)
    return binding.getVariable(environment_name)
}