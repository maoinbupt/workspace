package cn.reamongao.bspatchdemo;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class JniTest {
    public static native String accessMethod();

    static {
        System.loadLibrary("jni_test");
    }
}
