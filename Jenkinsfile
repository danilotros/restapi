       pipeline{
           agent{label 'principal'}
           tools{
               jdk 'JDK_11'
               gradle 'Gradle 7.5.1'
           }
           stages{
            stage('Execute Test'){
                   steps{
                       tool name: 'JDK_11',type: 'jdk'
                       tool name: 'Gradle 7.5.1', type:'gradle'
                       bat "gradle clean test aggregate"
                   }
                       post{
                               always{
                                      publishHTML([allowMissing: false,
                                                   alwaysLinkToLastBuild: false,
                                                   keepAll: false, reportDir: 'target/serenity',
                                                   reportFiles: 'overview-features.html',
                                                   reportName: 'HTML Report',
                                                   reportTitles: ''])
                               }

                           }
               }

           }

       }