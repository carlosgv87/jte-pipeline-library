Object call(String environment_name) {
    log.debug(binding)
    log.debug(binding.getPrimitiveNames())
    return binding.getVariable(environment_name)
}