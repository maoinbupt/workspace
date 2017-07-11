#include <jni.h>
#include <string.h>

jstring Java_cn_reamongao_bspatchdemo_JniTest_accessMethod(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "Hello From JniTest.c");
}