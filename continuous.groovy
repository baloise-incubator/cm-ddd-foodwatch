pipeline {
    agent any

    options {
        skipStagesAfterUnstable()
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '28'))
        timeout(time: 1, unit: 'HOURS')
        timestamps()
    }

    stages {
        stage("Build and Test") {
            steps {
                notifyBitBucket state: "INPROGRESS"
                mavenbuild mavenArgs: "-DcreateChecksum=true -Dmaven.javadoc.skip=true", uploadArtifactsWithBranchnameInVersion: true
                script {
                    pomInfo = readMavenPom file: 'pom.xml'
                    currentBuild.description = pomInfo.version
                }
            }
        }

        stage("Sonar Code Quality Analysis") {
            steps {
                sonar()
            }
        }
    }

    post {
        success {
            notifyBitBucket state: "SUCCESSFUL"
        }

        fixed {
            mailTo status: "SUCCESS", actuator: true, recipients: [], logExtract: true
        }

        failure {
            notifyBitBucket state: "FAILED"
            mailTo status: "FAILURE", actuator: true, recipients: [], logExtract: true
        }

        always {
            junit allowEmptyResults: true, testResults: '**/target/*-reports/TEST*.xml'
        }
    }
}
