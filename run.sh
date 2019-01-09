#!/bin/sh

mvn clean
mvn package
mvn exec:java -Dexec.mainClass="bot.discord.dbsk.App" -s "/usr/share/maven/conf/settings.xml"
