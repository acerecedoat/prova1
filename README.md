# prova1


Automation project for ALM billing and accounting processes.


## Build Java Project

Docker image build is integrated into maven build process:

> mvn clean package -Ddocker.skip=false -Ddocker.santander.com:5000/ -Ddocker.username=USRNAME -Ddocker.password=SECRET

## Run Docker Iimage

> docker run -d --name santander-billing -p 8080:8080 -e STORAGE_FOLDER=/tmp/alm-billing docker.santander.com:5000/santander/alm-automation-billing

Run standalone spring boot application :

> java -jar target/alm-automation-billing-0.1-SNAPSHOT.jar -DSTORAGE_FOLDER=/tmp/alm-billing 

#### Properties configuration


adasdad

adadsaasdas

da

sdasd

asd

ads

a
dsadsasd

asd

a

dsas

asd

a

asd

asdasdsa


asdasd

asdasda


adsada


## How to run in localhost and test application

1- Run docker image setting git hub user id as authorized user to login: [go](#run-docker-image).


## Urls

Service urls are shown from swagger utility:

. [http://localhost:8080/ui](http://localhost:8080/ui)

. [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


#### Properties configuration


adasdad
adadsa