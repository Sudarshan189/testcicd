pipeline {
agent any

stages {
    stage ('Print Information') {
        steps {
            echo "Running ${BUILD_NUMBER} on ${JENKINS_URL}"
        }
    }

    stage ('Competing Build') {
        steps {
            echo "Build Completed for ${BUILD_NUMBER}"
        }
    }
}

}