# alm-automation-billing

Automation project for ALM billing and accounting processes.

Docker image build is integrated into github actions (see __.github/workflows/maven.yml__):

> docker build -t $REPO:latest -t $REPO:${GITHUB_SHA::8} .

Each change in master branch starts new build and, if build has done successfully, new docker image snapshot is deployed to github packages of this github repository.


## Run docker image

> docker run -d --name santander-billing -p 8080:8080 -e STORAGE_FOLDER=/tmp/alm-billing docker.santander.com:5000/santander/alm-automation-billing


