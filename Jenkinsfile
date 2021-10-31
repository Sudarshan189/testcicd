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

    stage ('Deploy to Artifact') {
        steps {
            sh 'mvn clean deploy -DskipTests'
        }
    }

    stage ('Competing Deployment to artifact') {
        steps {
            echo "Build Completed for ${BUILD_NUMBER}"
        }
    }

    stage ('Increase Maven Version') {
        steps {
            sh "mvn build-helper:parse-version versions:set -DnewVersion=\${parsedVersion.nextMajorVersion}.0.0 versions:commit"
        }
    }

}

}