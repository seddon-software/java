#! /bin/sh

#  set JDK=C:\Program Files\Java\jdk1.5.0_01
#  set CLASSPATH=.
#  set PATH=.;%JDK%\bin


#REM -- run
cd ..
#export LD_LIBRARY_PATH=/Users/seddon/home/workspace/Java/NativeCode/src
#java -Djava.library.path="/Users/seddon/home/workspace/Java/NativeCode/src" JNITest
java -Djava.library.path="." JNITest
#java JNITest







