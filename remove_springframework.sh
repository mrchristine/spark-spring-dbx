#!/bin/bash

to_del=`ls /databricks/jars/ | grep springframework`
echo "Deleting spring jars: "
for x in $to_del; do
  echo $x
  rm /databricks/jars/$x
done
