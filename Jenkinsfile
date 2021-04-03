node{
  stage('SCM chekout'){
    
      git branch: 'main', url: 'https://github.com/Issames/Application.git'
  }
    stage('Compile-Package'){
      // Maven home path
      def mvnHomes = tool name: 'maven-3.6.3', type: 'maven'

      sh  "${mvnHome}/bin/mvn package"
    }
  stage('mail Notification'){
    mail bcc: '', body: '''Build now !!!!
    Alert!!!!''', cc: '', from: '', replyTo: '', subject: 'starting jenkins', to: 'issame.lamchabrag@uit.ac.ma'
 }
  def notifySuccessful() {
  slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")

  hipchatSend (color: 'GREEN', notify: true,
      message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"
    )
  }
  
}
