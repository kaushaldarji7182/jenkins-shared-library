def call(Map config = [:]) {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    echo 'Checking out source code...'
                    checkout scm
                }
            }

            stage('Unit Tests') {
                steps {
                    echo 'Running unit tests...'
                    sh './gradlew test'
                }
            }

            stage('Deploy') {
                when {
                    expression { return config.deployEnv != null }
                }
                steps {
                    echo "Deploying to environment: ${config.deployEnv}"
                    sh "./deploy.sh ${config.deployEnv}"
                }
            }
        }
    }
}

