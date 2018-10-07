def environment   =['dev']
def gitBranch     =['master']
def jobdslscripts =["test/jobdsl.groovy"]

pipelineJob('testadminjob')
        {
            description('testadmin job')
            logRotator(5,5)
            parameters {
                choiceParam('gitbranch',gitBranch, '')
                choiceParam('environment',environment, '')
            }
            definition{
                cps{
                    script(readFileFromWorkspace(jobdslscripts))
                    sandbox()
                }

            }