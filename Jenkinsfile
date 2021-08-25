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
            bat 'mvn clean compile'
          }
        }

      }
    }

    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }

    stage('Report') {
      parallel {
        stage('Test Report') {
          steps {
            junit 'target/surefire-reports/TEST-*.xml'
          }
        }

        stage('Package') {
          steps {
            bat 'mvn package'
            archiveArtifacts 'target/*.jar'
          }
        }

      }
    }

  }
  tools {
    maven 'maven_3.6.3'
  }
}