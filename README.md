# Instructions of deploying to AKS
Clone repo to local

## Build Image
1. mvn clean install
2. docker login
3. docker build --tag hexinlai/hello-world:latest .
4. docker push hexinlai/hello-world:latest

## Create Resource Group and AKS
1. az login -t tenantId
2. az group create --name resourcegroupname --location resourcegrouplocation
3. az aks create --resource-group resourcegroup --name clustername --node-count 1 --enable-addons monitoring --generate-ssh-keys
4. az aks get-credentials --resource-group resourcegroupname --name clustername

##Deploy to AKS
1. kubectl apply -f hello-world-deployment.yaml
2. kubectl expose deployment hello-world --type=LoadBalancer --name=hello-world

## Health Check
1. kubectl get services hello-world
2. kubectl get pods

## Delete Pods
1. kubectl delete services hello-world
2. kubectl delete deployment hello-world
