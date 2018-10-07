def environment ='dev'
def gitBranch   ='master'


pipelineJob('testadminjob')
        {
            description('testadmin job')
            logRotator('2,2')
            parameters {
                choiceParam('gitbranch',gitBranch, '')
                choiceParam('environment',environment, '')
            }
            definition{
                cps{
                    script(readFileFromWorkspace('test/jobdsl.groovy'))
                    sandbox()
                }

            }

        }