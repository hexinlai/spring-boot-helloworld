APPLICATION=$1
VERSION=$2

if [ $# -ne 2 ];then
echo “usage ./deployAndStart [appname] [version]”
exit 
fi

echo ${APPLICATION}:${VERSION}

less ${APPLICATION}-template.yaml | sed -e "s/application/${APPLICATION}/g" -e "s/version/${VERSION}/g" >> ${APPLICATION}.yaml

sleep 60

kubectl apply -f ${APPLICATION}.yaml

sleep 30

kubectl get services ${APPLICATION}

kubectl get pods --output=wide

