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
  }catch(e) {
   emailext body: '$DEFAULT_CONTENT',
     recipientProviders: [
            [$class: 'CulpritsRecipientProvider'],
            [$class: 'DevelopersRecipientProvider'],
            [$class: 'RequesterRecipientProvider']
        ], 
        replyTo: '$DEFAULT_REPLYTO', 
        subject: '$DEFAULT_SUBJECT',
        to: 'issame.lamchabrag@uit.ac.ma'
    throw err
}
  
}
