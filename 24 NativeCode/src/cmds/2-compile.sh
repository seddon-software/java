#! /bin/sh

#  set JDK=C:\Program Files\Java\jdk1.5.0_01
#  set CLASSPATH=.
#  set PATH=.;%JDK%\bin


#REM -- run

# To include the native code in the compilation of the Java program, 
# we need to compile our native C++ code into a dynamic library. 
# JNI shared/dynamic libraries have different extensions on different OS:
# On OSX:	 	.jnilib
# On Windows:	.dll
# On Linux : 	.so



INCLUDES=/Library/Java/JavaVirtualMachines/jdk1.8.0_20.jdk/Contents/Home/include
set -x
cd ..
clang++ -I $INCLUDES -I $INCLUDES/darwin -shared -o libMySharedLib.jnilib NativeMethod.cpp
#clang++  -I $INCLUDES -I $INCLUDES/darwin -c NativeMethod.cpp
#ar -r libMySharedLib.a  NativeMethod.o
#gcc f_main.c f2.c f3.c -L../mylib -lf1 -o f.exe







