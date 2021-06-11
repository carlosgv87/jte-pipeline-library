Object call(String environment_name) {
    log.debug(binding)
    log.debug(binding.variables)
    log.debug(binding.getProperties())
    log.debug(jte.application_environments)
    return binding.getVariable(environment_name)
}