@echo off
REM -----------------------------------------------------------------
REM
REM	run
REM
REM -----------------------------------------------------------------

  title JNI

REM -- set paths
  set JDK=C:\Program Files\Java\jdk1.5.0_01
  set CLASSPATH=.
  set PATH=.;%JDK%\bin

@echo on

REM -- run
  cd ..
  java -Djava.library.path="NativeCode" NativeCode.JNITest
  pause







