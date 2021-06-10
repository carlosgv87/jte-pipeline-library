String call(env_data) {
    def appData = readYaml(file: "releases/${env_data.short_name}.yaml")
    return [
            "namespace": appData["microservice-helm-chart"]["namespace"],
            "name"     : appData["microservice-helm-chart"]["app"]["name"],
            "image"    : appData["microservice-helm-chart"]["app"]["image"] ?: appData["microservice-helm-chart"]["app"]["name"],
            "version"  : appData["microservice-helm-chart"]["app"]["version"]
    ]
}