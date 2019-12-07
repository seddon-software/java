#! /bin/sh
# -- set paths
export JDK=/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk
export CLASSPATH=.
export PATH=.:$JDK/bin:$PATH
ls $JDK
set -x
# -- compile
  cd ..
  ls
  javac MyPackage/NativeClass.java
  javac JNITest.java

# -- generate C headers
  javah -jni -d NativeCode MyPackage.NativeClass








