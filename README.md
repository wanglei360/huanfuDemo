
    添加了3.0之后多渠道打包的方式，比在3.0之前稍微的多了一点配置
    baseActivity 中需要添加一些配置
    要换肤的控件，必须加        skin:enable="true"
    Application需要初始化
    皮肤工程不需要java文件夹和res中layout，工程直接build apk,然后把apk的后缀名改成 .skin就可以
    library用到了v4
    在library中，如果缺少功能可以在entity.AttrFactory中添加支持，然后像entity.SrcAttr一样去实现就好
介绍换肤的一个博客：[Android主题换肤 无缝切换](https://www.jianshu.com/p/af7c0585dd5b)

感谢：[Android-Skin-Loader](https://github.com/fengjundev/Android-Skin-Loader)