pipeline {
    agent any
    stages {
        // stage("verify tooling") {
        //     steps {
        //         sh '''
        //         docker version
        //         docker info
        //         docker compose version 
        //         curl --version
        //         jq --version
        //         '''
        //     }
        // }
        stage('Scm Checkout'){
            steps {
                git branch: 'main', credentialsId: 'gitHub', url: 'https://github.com/theoleprince/deploiement-docker'
            }
        }
        stage('Docker compose up Build'){
            steps {
                sh '''
                sudo chown jenkins:docker /var/run/docker.sock
                sudo service docker start
                docker compose up --build
                '''
            }
        }
    }
    
}