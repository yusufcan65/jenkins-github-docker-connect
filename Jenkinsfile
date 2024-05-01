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
                    userRemoteConfigs: [[url: 'https://github.com/serkan-can-eyvaz/yudududududu']]
                )
                bat 'mvn clean install'
            }
        }

        stage('Build docker image'){
            steps{
                script{
                    docker.build("yusuf/app:${env.BUILD_NUMBER}")
                }
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
        stage('Run Docker Container') {
                    steps {
                        script {
                            docker.image("yusuf/app:${env.BUILD_NUMBER}").run("-d -p 6530:6530 --name demo-container")
                        }
                    }
                }
    }
}