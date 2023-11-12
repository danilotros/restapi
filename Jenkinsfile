       pipeline{
           agent{label 'principal'}
           tools{
               jdk 'JDK_11'
               gradle 'Gradle 7.1.1'
           }
           stages{
            stage('Execute Test'){
                   steps{
                       tool name: 'JDK_8',type: 'jdk'
                       tool name: 'Gradle 7.1.1', type:'gradle'
                       bat "gradle clean test"
                   }
                       post{
                               always{
                                      publishHTML([allowMissing: false,
                                                   alwaysLinkToLastBuild: false,
                                                   keepAll: false, reportDir: 'target/cucumber-html-reports',
                                                   reportFiles: 'overview-features.html',
                                                   reportName: 'HTML Report',
                                                   reportTitles: ''])
                               }

                           }
               }

           }

       }