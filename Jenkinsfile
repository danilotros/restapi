       pipeline{
           agent{label 'principal'}
           tools{
               jdk 'JDK_11'
               gradle 'Gradle 7.5.1'
           }
           environment {
                   sonar_scanner = tool 'sonnar-scanner'
               }
           stages{
            stage('sonar'){
            steps{
                 withSonarQubeEnv('SonarQube'){
                     bat "${sonar_scanner}/bin/sonar-scanner -Dsonar.projectKey=restapi -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_a5b70eef4d3c8511d231d70da3696ed469553b67"
                 }
                 }
            }

            stage("Quality Gate") {
                        steps {
                          timeout(time: 5, unit: 'MINUTES') {
                            waitForQualityGate abortPipeline: true
                          }
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
               stage('Post Email'){
                    steps{
                        emailext attachLog: true, body: 'prueba', recipientProviders: [buildUser(), contributor()], subject: 'prueba', to: 'danielgarcia10211@gmail.com'
                    }
               }

           }

       }