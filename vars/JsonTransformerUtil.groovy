def parseDeployJsonAndSetEnvVars(String jsonFilePath) {
    def jsonFile = new File(jsonFilePath)
    def jsonSlurper = new groovy.json.JsonSlurper()
    def deployment = jsonSlurper.parse(jsonFile)
    
    def ipaddress = deployment.ipaddress
    def username = deployment.username
    def hostname = deployment.hostname
    
    def envVarName = "${ipaddress}-${username}-${hostname}".replaceAll("\\.", "_")
    def envVarValue = "${ipaddress}-${username}-${hostname}"
    
    // Set the environment variable
    env."${envVarName}" = envVarValue
    
    // Print to confirm
    println "Set environment variable: ${envVarName}=${envVarValue}"
    
    return envVarValue  // Return the environment variable value
}
