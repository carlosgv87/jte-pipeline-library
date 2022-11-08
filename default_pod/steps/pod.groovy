void call(body) {
    podTemplate(showRawYaml: true, yaml: """
apiVersion: v1
kind: Pod
metadata:
  namespace: default
spec:
  containers:
    - name: dind
      image: docker:20.10.11-dind
      command:
        - cat
      securityContext:
        privileged: true
      volumeMounts:
        - name: docker
          mountPath: /var/lib/docker
      env:
        - name: "DOCKER_HOST"
          value: "tcp://localhost:2376"
        - name: "DOCKER_TLS_VERIFY"
          value: "1"
  volumes:
    - name: docker
      emptyDir: {}
""") {
        steps.node(POD_LABEL) {
            body()
        }
    }
}