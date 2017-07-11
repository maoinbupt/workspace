#include <jni.h>
#include <string.h>

jstring Java_cn_reamongao_bspatchdemo_BSPatch_bspatch(JNIEnv *env, jobject thiz, jstring oldfile, jstring newfile, jstring patchfile) {

    return (*env)->NewStringUTF(env, "Hello From bspatcher.c");
}