#!/bin/bash

echo "Delete old jar"
dbfs --profile e2demo rm "dbfs:/home/mwc/jars/export-agent-7.0.jar"

echo
echo "rebuild jar..."
mvn clean package

echo 
echo "upload jar..."
dbfs --profile e2demo cp target/export-agent-7.0.jar "dbfs:/home/mwc/jars/export-agent-7.0.jar"

echo "Upload completed!"
