
    baseActivity 中需要添加一些配置
    要换肤的控件，必须加        skin:enable="true"
    Application需要初始化
    皮肤工程不需要java文件夹和res中layout，工程直接build apk,然后把apk的后缀名改成 .skin就可以
    library用到了v4
    在library中，如果缺少功能可以在entity.AttrFactory中添加支持，然后像entity.SrcAttr一样去实现就好


    感谢：[Android-Skin-Loader](https://github.com/fengjundev/Android-Skin-Loader)