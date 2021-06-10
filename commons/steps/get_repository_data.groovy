String call(scm_data) {
    def repositoryName = ""
    try {
        repositoryName = scm_data.GIT_URL_1 ? scm_data.GIT_URL_1.tokenize('/')[3].split("\\.")[0] : scm_data.GIT_URL.tokenize('/')[3].split("\\.")[0]
    } catch (e) {
        repositoryName = scm_data.GIT_URL_1 ? scm_data.GIT_URL_1.tokenize('/')[1].split("\\.")[0] : scm_data.GIT_URL.tokenize('/')[1].split("\\.")[0]
    }
    def countryCode = repositoryName.split("-").last()
    if (countryCode == "ops") {
        countryCode = "es"
    }
    return [
            "country_code"  : countryCode,
            "repositoryName": repositoryName
    ]
}