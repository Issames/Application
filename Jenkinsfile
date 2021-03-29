node{
  stage('SCM chekout'){
      git branch: 'main', url: 'https://github.com/Issames/Application.git'    }
    stage('Compile-Package'){
      sh  'mvn-package'
    }
 }
