package cn.reamongao.bspatchdemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;

/**
 * Created by GaoFeng on 2017.07.11.
 */

public class KotlinTest extends Activity{

    String packageName = "cn.reamongao.bspatchdemo";

    private int getVersionCode(){
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }

        File file = new File("path");


        return 0;
    }

    private String getSDCardPath(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {// 挂载上
            return Environment.getExternalStorageDirectory().getPath();
        }
        return "";
    }

}
