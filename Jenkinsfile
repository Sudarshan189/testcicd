pipeline {
agent any

tools {
    maven "M3"
}

stages {
    stage ('Print Information') {
        steps {
            echo "Running ${BUILD_NUMBER} on ${JENKINS_URL}"
        }
    }

    stage ('Unit Test') {
        steps {
            sh 'mvn clean test'
        }
    }

    stage ('Deploy to Artifact') {
        steps {
            sh 'mvn clean deploy -DskipTests'
        }
    }

    stage ('Competing Build') {
        steps {
            echo "Build Completed for ${BUILD_NUMBER}"
        }
    }
}

}