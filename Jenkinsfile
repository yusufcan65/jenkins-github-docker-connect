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
                    userRemoteConfigs: [[url: 'https://github.com/yusufcan65/jenkins-github-docker-connect.git']]
                )
                bat 'mvn clean install'
            }
        }

        stage('Build docker image'){
            steps{
                script{
                    docker.build("demo5:${env.BUILD_NUMBER}")
                }
            }
        }



        stage('Run Docker Container') {
                    steps {
                        script {
                            docker.image("demo5:${env.BUILD_NUMBER}").run("-d -p 6530:6530 --name demo-container")
                        }
                    }
                }

    }

}