node{
  try{
  stage('SCM chekout'){
    
      git branch: 'main', url: 'https://github.com/Issames/Application.git'
  }
    stage('Compile-Package'){
      // Maven home path
      def mvnHome = tool name: 'maven-3.6.3', type: 'maven'

      sh  "${mvnHome}/bin/mvn packages"
    }
  stage('mail Notification'){
    mail bcc: '', body: '''Jenkins Alert !!!!
    Alert!!!!''', cc: '', from: '', replyTo: '', subject: 'starting jenkins', to: 'issame.lamchabrag@uit.ac.ma'
    
 }
  }catch(err){
    emailext body: "${err}", subject:'Failure',to:'issame.lamchabrag@uit.ac.ma'
}
}
