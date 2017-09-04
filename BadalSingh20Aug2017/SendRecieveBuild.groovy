
job('mailer-Notification') {
    publishers {
        extendedEmail('badal.singh2432@gmail.com', 'Build', 'Confirmation Required') {
            trigger('PreBuildTrig')
            trigger(triggerName: 'ArtifactsBuild', subject: 'Release Notification action expected', body: 'Hi StakeHolder, Release packaging has been successfully done with the latest modification.Waiting for business sign-off.', recipientList: 'Badal.singh2433@gmail.com',
                    sendToDevelopers: true, sendToRequester: true, includeCulprits: true, sendToRecipientList: false)
            configure { node ->
                node / contentType << 'html'
            }
        }
    }
}

job('mailer-On-Approval') {
    publishers {
        extendedEmail('seleniumantjar@gmail.com', 'Build', 'Approval') {
            trigger('PreBuildTrig1')
            trigger(triggerName: 'ArtifactsBuild', subject: 'Release Notification action expected', body: 'Hi Release Team, Approval granted please go ahead', recipientList: 'Badal.singh2433@gmail.com',
                    sendToDevelopers: true, sendToRequester: true, sendToReleaseTeam: true, includeCulprits: true, sendToRecipientList: false)
            configure { node ->
                node / contentType << 'html'
            }
        }
    }
}

job('buildPipelineTrigger0') {
    publishers {
        buildPipelineTrigger('QaTest1-Cluster-Node1, QaTest2-cluster-Node2')
    }
}

job('buildPipelineTrigger1') {
    publishers {
        buildPipelineTrigger('deploy-Job-1, deploy-job-2') {
            parameters {
                predefinedProp('GIT_COMMIT', '$GIT_COMMIT')
                predefinedProp('MyQaTrig1', '$#15')
            }
        }
    }
}