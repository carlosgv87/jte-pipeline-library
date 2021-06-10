Object call(String environment_name) {
    log.debug(binding)
    return binding.getVariable(environment_name)
}