#!/bin/bash

declare -r IMAGE_NAME="artifactory.rnd-hub.com:5001/wsng/webserver_template"
declare -r IMAGE_TAG="latest"
declare -r APP_PORT="8123"

echo "Starting container for image '$IMAGE_NAME:$IMAGE_TAG', exposing port $APP_PORT/tcp"
docker run -p $APP_PORT:$APP_PORT $IMAGE_NAME:$IMAGE_TAG