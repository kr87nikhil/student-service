pipeline {
  agent any
  tools {
    maven 'maven_3.6.3'
  }
  
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

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv(credentialsId: 'sonarQube_localhost', installationName: 'My SonarQube Server') {
          bat '''
              mvn install sonar:sonar ^
                -Dsonar.sonar.projectKey=student-service ^
                -Dsonar.sonar.projectName=Stundent-Registration ^
                -Dsonar.sonar.projectVersion=0.0.1-SNAPSHOT ^
                -Dsonar.sonar.sources=src ^
                -Dsonar.sonar.binaries=target/classes ^
                -Dsonar.sonar.language=Java ^
                -Dsonar.sonar.sourceEncoding=UTF-8
              '''
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
          // true = set pipeline to UNSTABLE, false = don't
          waitForQualityGate abortPipeline: true
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

  post {
    failure {
      emailext body: '$DEFAULT_CONTENT', recipientProviders: [developers(), requestor()], subject: '$DEFAULT_SUBJECT'
    }
  }
}