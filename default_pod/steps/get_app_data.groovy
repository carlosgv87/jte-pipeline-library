String call(scm_data) {
    def repositoryName = scm_data.GIT_URL.tokenize('/')[3].split("\\.")[0]
    return [
            "repositoryName": repositoryName
    ]
}