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
  }catch (err) {
    emailext body: "${err}", subject: 'Failure', to: 'issame.lamchabrag@uit.ac.ma'
  }
}
