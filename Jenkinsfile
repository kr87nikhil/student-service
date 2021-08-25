pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git(url: 'https://github.com/kr87nikhil/student-service', branch: 'main', credentialsId: 'GitHub')
        sh 'mvn compile'
      }
    }

    stage('Test') {
      steps {
        tool(name: 'maven', type: 'maven_3.6.3')
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