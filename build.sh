#!/bin/bash

cd src

javac $(find . -name "*.java")
jar cfm Test.jar ../Manifest.txt $(find . -name "*.class")
rm $(find . -name "*.class")

mv Test.jar ..