node{
  try{
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
  }catchError(err){
    emailext body: "${err}", subject: 'Failure', to:'issame.lamchabrag@uit.ac.ma'
}
}
