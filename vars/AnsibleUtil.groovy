def runAnsiblePlaybook(String playbook, String password) {
    sh """
        ansible-playbook -vvvvv ${playbook} -e "ansible_become_pass=${password}"
    """
}
