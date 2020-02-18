pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage('Compile') {
            steps {
                // sh 'docker --version'
                echo 'Executing Compile'
                mvn compile
            }
        }

        stage('Tests') {
            steps {
                mvn test
                echo 'Executing Second Stage'
            }
        }
        stage('Install') {
            steps {   
                mvn install -DskipTests
            }
        }

        
       
    }
}