package cn.reamongao.bspatchdemo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import org.jetbrains.anko.async
import java.net.URL
import cn.reamongao.bspatchdemo.KotlinTest.readInputStream
import java.io.*
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {

    internal var packageName = "cn.reamongao.bspatchdemo"
    internal var PATCH_DOMAIN = "http://10.2.148.52:8080/files/sohuvideo.apk"
    internal var PATH_PATCH_NAME = "sohuvideo.apk"
    internal var PATH_OLD_FILE_NAME = "com.reamongao.bspatchdemo.apk"
    internal var PATH_NEW_FILE_NAME = "app.apk"
    internal var TAG = "MainActivity"
    val SDCARD_PATH = Environment.getExternalStorageDirectory().toString() + File.separator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        val tv = findViewById(R.id.sample_text) as Button

        tv.setOnClickListener {
            //并行任务
            ApkUpdateTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        }
        tv.setText("当前版本： " +getVersionCode())
//        tv.text = stringFromJNI()
//        val str = JniTest.accessMethod()


        if (getVersionCode()<= 2){


//            async {
                // 1异步下载
                try {
                    Log.d(TAG,"开始异步下载文件...")
//                    val requestUrl = URL(PATCH_DOMAIN)
//                    val patchFile = File(SDCARD_PATH, PATH_PATCH_NAME)
//                    patchFile.writeBytes(requestUrl.readBytes())
                    Thread(Runnable { downLoadFromUrl(PATCH_DOMAIN,PATH_PATCH_NAME,SDCARD_PATH)}).start()

                    Log.d(TAG,"异步下载文件完成...")
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                // 2增量升级
//                val resultInt = BSPatch.bspatcher("oldfile1","newFile","patchfile")
//                if (resultInt >0 ){
//                    toast("generate new APK success")
//                }

                // 3主线程拉起安装
//                uiThread {
//                    val file = File("path")
//
//                    installApk(file, this@MainActivity)
//                    longToast("Request performed")
//                }
            }
//        }


    }

    private fun getVersionCode(): Int {
        try {
            val packageInfo = packageManager.getPackageInfo(packageName, 0)
            return packageInfo.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        return 0
    }

    fun installApk(path: String, context: Context) {
        val file = File(path)
        if (file != null && file.exists()) {
            val intent = Intent("android.intent.action.VIEW")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
            context.startActivity(intent)
        }
    }


    /**
     * 合并增量文件任务
     */
    private inner class ApkUpdateTask : AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void): Boolean? {
            val oldApkPath = getCurApkPath(this@MainActivity)
            val oldApkFile = File(oldApkPath)
            val patchFile = File(getPatchFilePath())
            if (oldApkFile.exists() && patchFile.exists()) {
                Log.d(TAG,"正在合并增量文件...")
                val newApkPath = getNewApkFilePath()
                BSPatch.bspatcher(oldApkPath, newApkPath, getPatchFilePath())
                return true
            }
            return false
        }

        override fun onPostExecute(result: Boolean?) {
            super.onPostExecute(result)
            if (result!!) {
                Log.d(TAG,"合并成功，开始安装")
                installApk(getNewApkFilePath(), this@MainActivity)
            } else {
                Log.d(TAG,"合并失败")
            }
        }
    }

    /**
     * 获取当前应用的Apk路径
     */
    fun getCurApkPath(context: Context): String {
        var context = context
        context = context.applicationContext
        val applicationInfo = context.applicationInfo
        val apkPath = applicationInfo.sourceDir
        return apkPath
    }

    /**
     * 获取patch文件路径
     */
    private fun getPatchFilePath(): String {
        return SDCARD_PATH + PATH_PATCH_NAME
    }

    /**
     * 获取增量更新后的Apk路径
     */
    private fun getNewApkFilePath(): String {
        return SDCARD_PATH + PATH_NEW_FILE_NAME
    }


    }


/**
 * 从网络Url中下载文件
 * @param urlStr
 * *
 * @param fileName
 * *
 * @param savePath
 * *
 * @throws IOException
 */
fun downLoadFromUrl(urlStr: String, fileName: String, savePath: String) {
    val url = URL(urlStr)
    val conn = url.openConnection() as HttpURLConnection
    //设置超时间为3秒
    conn.setConnectTimeout(3 * 1000)
    //防止屏蔽程序抓取而返回403错误
    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)")

    //得到输入流
    val inputStream = conn.getInputStream()
    //获取自己数组
    val getData = readInputStream(inputStream)

    //文件保存位置
    val saveDir = File(savePath)
    if (!saveDir.exists()) {
        saveDir.mkdir()
    }
    var path = ""
    if (savePath.endsWith(File.separator)){
        path = saveDir.toString() + fileName
    }else{
        path = saveDir.toString() + File.separator + fileName
    }
    val file = File(path)
    val fos = FileOutputStream(file)
    fos.write(getData)
    fos?.close()
    if (inputStream != null) {
        inputStream!!.close()
    }
    println("info:$url download success")

}

/**
 * 从输入流中获取字节数组
 * @param inputStream
 */
public fun readInputStream(stream: InputStream): ByteArray? /* nullable */ {
    val out = ByteArrayOutputStream(8192) /* `out` is a keyword, it may be better to choose another name for var */
    val buffer = ByteArray(8192)

    try {
        while (true) {
            val length = stream.read(buffer)
            if (length <= 0)
                break
            out.write(buffer, 0, length)
        }
        out.flush()
        return out.toByteArray()
    } catch (t: Throwable /* it's better to catch specific exception here, or, at least, Exception, but not Throwable */) {
        // behave
    }
    return null
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
