       pipeline{
           agent{label 'principal'}
           tools{
               jdk 'JDK_11'
               gradle 'Gradle 7.5.1'
           }
           stages{
            stage('SonarQube analysis'){
                withSonarQubeEnv('SonarQube') { // Will pick the global server connection you have configured
                      bat 'sonar-scanner -Dsonar.projectKey=restapi -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_a5b70eef4d3c8511d231d70da3696ed469553b67'
                    }
            }
            stage('Execute Test'){
                   steps{
                       tool name: 'JDK_11',type: 'jdk'
                       tool name: 'Gradle 7.5.1', type:'gradle'
                       bat "gradle clean test aggregate"
                   }
                       post{
                               always{
                                    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, escapeUnderscores: false, keepAll: false, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
                               }

                           }
               }

           }

       }