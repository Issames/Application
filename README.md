## Application
this a web application for posting of job offers
## Running Locally

After installing Git, run:
```
git clone  https://github.com/Issames/Application.git  
cd Application
```
## Docker
```
to build the image , run:
docker build -t Application
```
check your image is created, run:
```
docker image ls
```
to run the app, run :
```
docker run -d -p 4000:80 Application
