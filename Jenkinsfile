pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Likitha-046/demoapp.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'cp target/demo-app-1.0-SNAPSHOT.war /var/lib/tomcat10/webapps/demo-app.war'
                sh 'systemctl restart tomcat10'
            }
        }
    }

    post {

        success {

            mail to: 'likithac321@gmail.com',
                 subject: 'Jenkins Build SUCCESS',
                 body: '''
Hello,

Your Maven Calculator project build was successful.

Stages completed:
- Checkout
- Build
- Test
- Package
- Deploy

Application deployed successfully on Tomcat.

Thank You
'''
        }

        failure {

            mail to: 'likithac321@gmail.com',
                 subject: 'Jenkins Build FAILED',
                 body: '''
Hello,

Your Jenkins pipeline build failed.

Please check Jenkins console output.

Thank You
'''
        }
    }
}
