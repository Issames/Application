node{
  stage('SCM chekout'){
    
      git branch: 'main', url: 'https://github.com/Issames/Application.git'
  }
    stage('Compile-Package'){
      // Maven home path
      def mvnHome = tool name: 'maven-3.6.3', type: 'maven'

      sh  "${mvnHome}/bin/mvn package"
    }
  stage('Send Email Notification'){
    mail bcc: '', body: '''Jenkins Alert !!!!
    Alert!!!!''', cc: '', from: '', replyTo: '', subject: 'Jenkins Jobs', to: 'issame.lamchabrag@uit.ac.ma'
    
 }
