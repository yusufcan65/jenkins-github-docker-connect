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
                    docker.build("yusuf65:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    docker.image("yusuf65:${env.BUILD_NUMBER}").run("-d -p 6530:5050 --name demo-container")
                }
            }
  }
}

}