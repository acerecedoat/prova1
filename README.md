# alm-automation-billing

Automation project for ALM billing and accounting processes.

Docker image build is integrated into github actions (see __.github/workflows/maven.yml__):

> docker build -t $REPO:latest -t $REPO:${GITHUB_SHA::8} .


asdasd a

## Run docker image

> docker run -d --name santander-billing -p 8080:8080 -e STORAGE_FOLDER=/tmp/alm-billing docker.santander.com:5000/santander/alm-automation-billing


