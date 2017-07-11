package cn.reamongao.bspatchdemo;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class BSPatch {

    public static native String bspatch(String oldfile, String newfile, String patchfile);

    static {
        System.loadLibrary("bspatcher");
    }
}
