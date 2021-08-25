pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/kr87nikhil/student-service', branch: 'develop', credentialsId: 'GitHub')
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Report') {
      steps {
        junit 'target/**/*.xml'
      }
    }

  }
}