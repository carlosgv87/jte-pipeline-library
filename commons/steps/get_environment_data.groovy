Object call(String environment_name) {
    log.debug("binding: " + binding)
    log.debug("binding.variables: " + binding.variables)
    log.debug("binding.getProperties(): " + binding.getProperties())
    log.debug("jte.application_environments: " + jte.application_environments)
    log.debug("jte.application_environments.environment_name: " + jte.application_environments."${environment_name}")
    return binding.getVariable(environment_name)
}