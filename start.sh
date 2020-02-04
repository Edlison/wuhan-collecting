#!/bin/bash
echo Application is starting...
nohup java -jar -Dspring.profiles.active=production target/collecting-0.0.1-SNAPSHOT.jar &
echo Application has started!