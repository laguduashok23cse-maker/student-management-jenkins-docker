pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build and Test') {
            steps { sh 'mvn -B clean test package' }
        }
        stage('Build Docker Image') {
            steps { sh 'docker compose build' }
        }
        stage('Deploy with Docker') {
            steps { sh 'docker compose up -d' }
        }
    }
    post {
        success { echo 'Student Management System deployed. Open http://localhost:8080' }
        failure { echo 'Pipeline failed. Check the stage logs above.' }
    }
}
