def vaultLoginAndRetrieveSecret(String username, String password, String objectId) {
    // Define the Vault address and login command
    def vaultAddr = env.VAULT_ADDR
    def loginCommand = "vault login -method=userpass username=${username} password=${password}"
    
    // Execute the Vault login command
    sh(script: loginCommand, returnStatus: true) // returnStatus: true allows capture of exit status

    // Define the command to retrieve the secret
    def getSecretCommand = "vault kv get -field=password secret/PRD_VM_LINUX_APP/${objectId}"
    
    // Retrieve the secret and capture its value
    def secret = sh(script: getSecretCommand, returnStdout: true).trim()
    
    return secret
}
