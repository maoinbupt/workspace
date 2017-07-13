package cn.reamongao.bspatchdemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by GaoFeng on 2017.07.11.
 */
@Deprecated
public class KotlinTest extends Activity{

    String packageName = "cn.reamongao.bspatchdemo";

    private int getVersionCode(){
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }



        return 0;
    }

    private String getSDCardPath(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {// 挂载上
            return Environment.getExternalStorageDirectory().getPath();
        }
        return "";
    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();


    }

}
