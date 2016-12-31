 #!/usr/bin/env bash
 source /etc/profile
 HOME=$(cd "$(dirname "$0")/../"; pwd)
 cd $HOME
 mkdir -p log
 libjar=`ls lib | grep .jar | awk '{jar=jar"'"lib/"'"$1":"} END {print jar}'`
 CONF_DIR=$HOME/conf
 CP=${CONF_DIR}:$libjar
 MAIN_CLASS=com.ptb.zeus.tool.App

 echo "java -cp ${CP}  ${MAIN_CLASS} $*"
 java -cp ${CP}  ${MAIN_CLASS} $*
 #nohup java -cp ${CP}  ${MAIN_CLASS} $* >>log/run.log 2>&1 &
