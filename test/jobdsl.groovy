
node('master'){
    stage('checkout')
            {
                delete dir ()
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '9b5320b1-2e43-4fc0-b906-9a6f4cfec42f', url: 'https://github.com/AkhilaGarlapally/dev.git']]]

            }
    stage('jobdsl')
            {
                jobDsl target : jobdslscripts
            }
}