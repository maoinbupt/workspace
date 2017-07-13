//#include <jni.h>
//#include "bspatch.c"
//
//
//JNIEXPORT jint Java_cn_reamongao_bspatchdemo_BSPatch_bspatcher(JNIEnv *env,  jclass type, jstring oldfile, jstring newfile, jstring patchfile) {
//
//    const char *oldApkPath = (*env)->GetStringUTFChars(env, oldfile, 0);
//    const char *newApkPath = (*env)->GetStringUTFChars(env, newfile, 0);
//    const char *patchPath = (*env)->GetStringUTFChars(env, patchfile, 0);
//
//    int argc = 4;
//    char* argv[4];
//    argv[0] = "bspatch";
//    argv[1] = oldApkPath;
//    argv[2] = newApkPath;
//    argv[3] = patchPath;
//
//
//
//    int ret =  bspatch(argc, argv);
//    (*env)->ReleaseStringUTFChars(env, oldfile, oldApkPath);
//    (*env)->ReleaseStringUTFChars(env, newfile, newApkPath);
//    (*env)->ReleaseStringUTFChars(env, patchfile, patchPath);
//
//    return ret;
//
//}