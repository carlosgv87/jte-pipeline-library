void call(repository_data, diff) {
    httpRequest(authentication: 'bitbucket',
            validResponseCodes: '201',
            contentType: 'APPLICATION_JSON_UTF8',
            httpMode: 'POST',
            requestBody: new groovy.json.JsonBuilder([content: [raw: "```diff\n${diff}```"]]).toString(),
            url: "https://api.bitbucket.org/2.0/repositories/BITBUCKET_WORKSPACE_NAME/${repository_data.repositoryName}/pullrequests/${env.CHANGE_ID}/comments")
}