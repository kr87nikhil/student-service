pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Git Checkout') {
          steps {
            git(url: 'https://github.com/kr87nikhil/student-service', branch: 'main', credentialsId: 'GitHub')
          }
        }

        stage('Compile') {
          steps {
            tool(name: 'maven_3.6.3', type: 'maven')
            bat 'mvn clean compile'
          }
        }

      }
    }

    stage('Test') {
      steps {
        tool(name: 'maven_3.6.3', type: 'maven')
        bat 'mvn test'
      }
    }

    stage('Result') {
      parallel {
        stage('Report') {
          steps {
            junit 'target\\surefire-reports\\*.xml'
          }
        }

        stage('Package') {
          steps {
            bat 'mvn package'
          }
        }

      }
    }

    stage('Artifacts') {
      steps {
        archiveArtifacts '**\\*.war'
      }
    }

  }
}