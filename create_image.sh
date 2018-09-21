#!/bin/bash

declare -r IMAGE_NAME="artifactory.rnd-hub.com:5001/wsng/webserver_template"
declare -r IMAGE_TAG="latest"

echo "Building image '$IMAGE_NAME:$IMAGE_TAG'"
docker build -t $IMAGE_NAME:$IMAGE_TAG .