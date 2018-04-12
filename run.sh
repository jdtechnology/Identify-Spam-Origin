#!/usr/bin/env bash

if [ -e target/scala-2.12/nameidentify.jar ]; then
    java -jar target/scala-2.12/nameidentify.jar
else
    sbt assembly
    java -jar target/scala-2.12/nameidentify.jar
fi