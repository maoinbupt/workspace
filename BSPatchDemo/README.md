
#BSPatchDemo

>利用bspatch和bsdiff进行apk的增量更新


### bsdiff简介

[bsdiff](http://www.daemonology.net/bsdiff/)和bspatch是一组开源的二进制查分工具，利用bsdiff对新旧apk文件查分生成补丁文件，再利用bspatch应用补丁文件与旧apk文件即可生成新apk文件，这样我们就可以实现android版本增量更新。


bsdiff和bspatch使用了[bzip2](http://www.bzip.org/downloads.html)压缩工具。

使用方法：

`bsdiff oldfile newfile patchfile`
`bspatch oldfile newfile patchfile`

>ps：demo中的rawlib包含了demo的1.0版本，2.0版本的apk和patch文件以及badiff和bspatch在windows下的可执行文件。demo中下载请求的是本地地址。





