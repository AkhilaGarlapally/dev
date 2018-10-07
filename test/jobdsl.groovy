node('master'){
    stage('checkout')
            {

                checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github', url: 'https://github.com/AkhilaGarlapally/dev.git']]]
            }
    stage('jobdsl')
            {
                jobDsl targets : jobdslscripts
            }

}








