#include <jni.h>
#include "bspatch.c"


int Java_cn_reamongao_bspatchdemo_BSPatch_bspatch(JNIEnv *env, jobject thiz, jstring oldfile, jstring newfile, jstring patchfile) {

    int number = 4;
    char *pathfile[] = {
                    "GAOFENG===",
                    oldfile,
                    newfile,
                    patchfile,
                };


    return bspatch(number, pathfile);
}