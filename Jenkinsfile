node{
  try{
  stage('SCM chekout'){
    
      git branch: 'main', url: 'https://github.com/Issames/Application.git'
  }
    stage('Compile-Package'){
      // Maven home path
      sh 'mvn clean package'
      
    }
  }catch (err) {
    emailext body: "${err}", subject: 'Failure', to: 'issame.lamchabrag@uit.ac.ma'
  }
}
