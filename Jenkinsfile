pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Git') {
          steps {
            git(url: 'https://github.com/kr87nikhil/student-service', branch: 'main', credentialsId: 'GitHub')
          }
        }

        stage('Compile') {
          steps {
            tool(name: 'maven', type: 'maven_3.6.3')
            bat 'mvn compile'
          }
        }

      }
    }

    stage('Test') {
      steps {
        tool(name: 'maven', type: 'maven_3.6.3')
        bat 'mvn test'
      }
    }

    stage('Report') {
      steps {
        junit 'target/**/*.xml'
      }
    }

  }
}