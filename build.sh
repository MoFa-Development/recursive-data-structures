#!/bin/bash

# Generate documentation and Test.jar

echo Generating documentation...

javadoc $(find src -name "*.java") -d doc

echo Generated documentation successfully!

echo Generating Test.jar...

cd src

javac $(find . -name "*.java")
jar cfm Test.jar ../Manifest.txt $(find . -name "*.class")
rm $(find . -name "*.class")

mv Test.jar ..

echo Generated Test.jar successfully!