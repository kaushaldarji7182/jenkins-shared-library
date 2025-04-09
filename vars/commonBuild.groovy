def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    echo "Checking out application source code..."
                    git url: 'https://github.com/kaushaldarji7182/k8s-helloworld.git', branch: 'main'
                }
            }

            stage('Unit Tests') {
                steps {
                    echo "Running unit tests..."
                }
            }

            stage('Deploy') {
                steps {
                    echo "Deploying application..."
                }
            }
        }

        post {
            success {
                echo "Pipeline completed successfully!"
            }
            failure {
                echo "Pipeline failed."
            }
        }
    }
}

