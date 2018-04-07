#!/bin/bash
################
#
# arg1 - port
#
#
################

port=$1

java -jar target/dependency/webapp-runner.jar --port $port --session-store memcache target/*.war
