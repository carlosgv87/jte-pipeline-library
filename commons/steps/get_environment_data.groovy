Object call(String environment_name) {
    log.debug("binding: " + binding)
    log.debug("binding.variables: " + binding.variables)
    log.debug("binding.getProperties(): " + binding.getProperties())
    log.debug("jte.application_environments: " + jte.application_environments)
    return binding.getVariable(environment_name)
}