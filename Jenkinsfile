pipeline{
    agent any
    stages{
        stage('Git clone'){
            steps{
                git 'https://github.com/karthikdeeraj/git-kd.git'
            }
        }
        stage('Maven Test'){
            steps{
                bat 'mvn test'
            }
        }
        stage('Maven Build'){
            steps{
                bat 'mvn package'
            }
        }
         stage('Maven Deploy'){
            steps{
                echo "Deploying war file"
            }
        }
    }
}
