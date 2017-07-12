package cn.reamongao.bspatchdemo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.async
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.io.File
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        val tv = findViewById(R.id.sample_text) as TextView
//        tv.text = stringFromJNI()
//        val str = JniTest.accessMethod()


        if (getVersionCode()<= 2){
            async {
                // 1异步下载
                val result = URL(PATCH_DOMAIN).readBytes()

                // 2增量升级
                val resultInt = BSPatch.bspatch("oldfile1","newFile","patchfile")
                if (resultInt >0 ){
                    toast("generate new APK success")
                }

                // 3主线程拉起安装
                uiThread {
                    val file = File("path")

                    installApk(file, this@MainActivity)
                    longToast("Request performed")
                }
            }
        }


    }

    internal var packageName = "cn.reamongao.bspatchdemo"
    internal var PATCH_DOMAIN = "192.168.1.3:8080"
    internal var PATH_PATCH_NAME = "apk.patch"
    internal var PATH_OLD_FILE_NAME = "com.reamongao.bspatchdemo.apk"
    internal var PATH_NEW_FILE_NAME = "app.apk"
    internal var TAG = "MainActivity"

    private fun getVersionCode(): Int {
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            return packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return 0
    }

    fun installApk(file: File, context: Context) {
        if (file != null && file.exists()) {
            val intent = Intent("android.intent.action.VIEW")
            intent.addFlags(268435456)
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
            context.startActivity(intent)
        }
    }

    private fun getSDCardPath(): String {
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {// 挂载上
            return Environment.getExternalStorageDirectory().path
        }
        return ""
    }











    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String
//
//    companion object {
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}
