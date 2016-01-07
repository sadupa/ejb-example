#!/usr/bin/env bash
mvn clean install -DskipTests -o
cp ear/target/sample-ear-1.0-SNAPSHOT.ear $JBOSS_HOME/server/default/deploy
echo '---------------------------------'
echo '.ear file copied to jboss server'
echo '---------------------------------'
