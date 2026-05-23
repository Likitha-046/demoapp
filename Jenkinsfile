pipeline {

    agent any

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
            mail to: 'likitha-046@gmail.com',
                 subject: 'Jenkins Build SUCCESS',
                 body: 'Calculator project deployed successfully!'
        }

        failure {
            mail to: 'likitha-046@gmail.com',
                 subject: 'Jenkins Build FAILED',
                 body: 'Build failed. Check Jenkins console.'
        }
    }
}
