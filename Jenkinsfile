pipeline {
    agent any
    tools {
        maven 'maven 3.5.0'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/yusufcan65/jenkins-github-docker-connect.git']]
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



        stage('Run Docker Container') {
                    steps {
                        script {
                            docker.image("yusuf/app:${env.BUILD_NUMBER}").run("-d -p 6530:8065 --name demo-container")
                        }
                    }
                }

    }

}