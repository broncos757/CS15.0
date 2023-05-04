#!/bin/bash

echo Configuring Java...
sleep 1
sudo rm -fr /Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)' >> ~/.bashrc
echo 'export CLASSPATH="'$PWD'/*:."' >> ~/.bashrc
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)' >> ~/.zshrc
echo 'export CLASSPATH="'$PWD'/*:."' >> ~/.zshrc

echo Making magic happen...
sleep 1
echo '. ~/.bashrc' >> ~/.bash_profile
echo '. ~/.zshrc' >> ~/.zprofile

echo Building a bamboo hut in Fiji...
sleep 1
rm macSetup.sh
rm windowsSetup.cmd
rm settings.zip

echo All set!
