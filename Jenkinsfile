pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn -B clean verify'
            }
        }

        stage('Build Docker Image and Deploy') {
            steps {
                sh 'docker compose -p student-management-jenkins-docker up -d --build'
            }
        }
    }

    post {
        success {
            echo 'Student Management System deployed successfully!'
            echo 'Application URL: http://localhost:8082'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}      
