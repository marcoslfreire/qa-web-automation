pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'saucedemo-login',
                        usernameVariable: 'SAUCEDEMO_USERNAME',
                        passwordVariable: 'SAUCEDEMO_PASSWORD'
                    )
                ]) {
                    bat 'mvn test'
                }
            }
        }
    }
}