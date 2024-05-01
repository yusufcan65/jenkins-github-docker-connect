pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yusufcan65/yudududududu'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("demo-app:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    docker.image("demo-app:${env.BUILD_NUMBER}").run("-d -p 6530:6530 --name demo-container")
                }
            }
        }
    }

}