def environment ='dev'
def gitBranch   ='master'

def jobdslscripts ='test/jobdsl.groovy'

pipelineJob('testadminjob')
        {
            description('testadmin job')
            logRotator('2,2')
            parameters {
                choiceParam('gitbranch',gitBranch, '')
                choiceParam('environment',environment, '')
            }
            definitions{
                cps{
                    script(readFileFromWorkspace(jobdslscripts))
                    sandbox()
                }

            }

        }