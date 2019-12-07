#include "NativeCode/MyPackage_NativeClass.h"
#include <iostream>
using namespace std;


JNIEXPORT void JNICALL 
  Java_MyPackage_NativeClass_nativeMethod(JNIEnv *, jobject)
{
    //_asm int 3
	cout << "native method called" << endl;
}

JNIEXPORT void JNICALL 
  Java_MyPackage_NativeClass_UseEnv(JNIEnv *env, jobject)
{
   jint version = env->GetVersion();
   cout << version << endl;
}


/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    Square
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_MyPackage_NativeClass_Square
  (JNIEnv *, jobject, jint n)
{
	jint result = n * n;
	return result;
}

/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    getLine
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_MyPackage_NativeClass_getLine
  (JNIEnv *env, jobject, jstring prompt)
{
	// _asm int 3
	char buf[128];
	const char *str = env->GetStringUTFChars(prompt, 0);
	printf("%s", str);
	env->ReleaseStringUTFChars(prompt, str);
	scanf("%s", buf);
	return env->NewStringUTF(buf);
}

/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    sumArray
 * Signature: ([I)I
 */
JNIEXPORT jint JNICALL Java_MyPackage_NativeClass_sumArray
  (JNIEnv *env, jobject, jintArray arr)
{
	jsize len = env->GetArrayLength(arr);
	int i, sum = 0;
	
	jint *body = (env)->GetIntArrayElements(arr, 0);

	for (i=0; i<len; i++) {
		sum += body[i];
	}
	
	env->ReleaseIntArrayElements(arr, body, 0);
	return sum;
}


/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    accessObject
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_MyPackage_NativeClass_accessObject
  (JNIEnv *env, jobject This)
{
	// _asm int 3
	jclass cl;
	jfieldID fid;
	jint fValue;
	cl = env->GetObjectClass(This);
	fid = env->GetFieldID(cl, "myVal", "I");
	fValue = env->GetIntField(This, fid);
	printf("Value of field is %d\n", fValue);
}

/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    makeCallback
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_MyPackage_NativeClass_makeCallback
  (JNIEnv *env, jobject This, jint depth)
{
	jclass cls = env->GetObjectClass(This);
	jmethodID mid = env->GetMethodID(cls, "callback", "(I)V");
	if (mid == 0) {
	    return;
	}
	cout << "about to call Java method ..." << endl;
	env->CallVoidMethod(This, mid, depth);
	cout << "returned from Java call." << endl;
}

/*
 * Class:     NativeCode_MyPackage_NativeClass
 * Method:    checkForException
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_MyPackage_NativeClass_checkForException
  (JNIEnv *env, jobject, jint x)
{
	jclass newExcCls;

	newExcCls = env->FindClass("java/lang/IllegalArgumentException");
	if(newExcCls == 0) return;
	
    if(x > 0) env->ThrowNew(newExcCls, "thrown from C++ code");
}




