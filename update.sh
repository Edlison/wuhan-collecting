#!/bin/bash
echo '自动更新Springboot项目脚本...'
echo '1. 拉取github代码...'
git pull
echo '2. 检查80端口是否被占用...'
pid_blog=`lsof -i :80|grep -v "PID"|awk '{print $2}'`
if [ "$pid_blog" != "" ];
then
    echo '8081端口被占用'
    echo $pid_blog
    kill -9 "$pid_blog"
    echo $pid_blog '进程已被杀死'
else
    echo "端口未被占用"
fi
echo '3. 清理原有项目...'
mvn clean
echo '4. 打包...'
mvn package
