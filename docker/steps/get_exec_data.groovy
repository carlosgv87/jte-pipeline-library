String call() {
    def execData = readYaml(file: "docker_exec.yaml")
    return [
            "imageName": execData["imageName"],
            "arguments": execData["arguments"]
    ]
}