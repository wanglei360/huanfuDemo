package com.demo.huanfudemo;

import android.app.Application;

import com.skin_library.loader.SkinManager;

//import cn.feng.skin.manager.loader.SkinManager;

//import com.skin_library.loader.SkinManager;

/**
 * 创建者：wanglei
 * <p>时间：18/2/5  15:15
 * <p>类描述：
 * <p>修改人：
 * <p>修改时间：
 * <p>修改备注：
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
        SkinManager.getInstance().load();
    }
}
