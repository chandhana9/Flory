#!/bin/sh

mvn clean
mvn package
mvn exec:java -Dexec.mainClass="bot.discord.dbsk.App" -s "/opt/maven/conf/settings.xml"
