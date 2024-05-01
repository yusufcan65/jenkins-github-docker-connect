pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/yusufcan65/yudududududu.git']]
                )
                bat 'mvn clean install'
            }
        }
        stage('Stop and Remove Existing Container') {
                                             steps {
                                                 script {
                                                   // Varolan container'ı durdur ve sil
                                                            bat 'docker stop demo-container '
                                                            bat 'docker rm demo-container'
                                                        }
                                                   }
                                        }
        stage('Build docker image'){
            steps{
                script{
                    docker.build("demo/app:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Run Docker Container') {
                    steps {
                        script {
                            docker.image("demo/app:${env.BUILD_NUMBER}").run("-d -p 9090:9090 --name demo-container")
                        }
                    }
                }
    }
}