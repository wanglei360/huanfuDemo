package com.demo.huanfudemo;

import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.skin_library.listener.ILoaderListener;
import com.skin_library.loader.SkinManager;
import com.skin_library.util.L;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.SettingService;

import java.io.File;
import java.util.List;

/**
 * baseActivity 中需要添加一些配置
 * 要换肤的控件，必须加        skin:enable="true"
 * Application需要初始化
 * 皮肤工程不需要java文件夹和res中layout，工程直接build apk,然后把apk的后缀名改成 .skin就可以
 * library用到了v4
 * 在library中，如果缺少功能可以在entity.AttrFactory中添加支持，然后像entity.SrcAttr一样去实现就好
 */
public class MainActivity extends BaseActivity {

    private static final String SKIN_NAME = "my_skin.skin";
    private static final String SKIN_DIR = Environment
            .getExternalStorageDirectory() + File.separator + SKIN_NAME;
    private boolean isOfficalSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void but(View view) {
        isOfficalSelected = !SkinManager.getInstance().isExternalSkin();

        AndPermission.with(MainActivity.this)
                .permission(Permission.WRITE_EXTERNAL_STORAGE)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        onSkinSetClick();
                    }
                }).onDenied(new Action() {
            @Override
            public void onAction(List<String> permissions) {
                SettingService settingService = AndPermission.permissionSetting(MainActivity.this);
                // 如果用户同意去设置：
                settingService.execute();
            }
        }).start();
    }

    private void onSkinSetClick() {
        if (!isOfficalSelected) {
            SkinManager.getInstance().restoreDefaultTheme();
            return;
        }
        File skin = new File(SKIN_DIR);

        if (skin == null || !skin.exists()) {
            Toast.makeText(getApplicationContext(), "请检查" + SKIN_DIR + "是否存在", Toast.LENGTH_SHORT).show();
            return;
        }

        SkinManager.getInstance().load(skin.getAbsolutePath(),
                new ILoaderListener() {
                    @Override
                    public void onStart() {
                        L.e("startloadSkin");
                    }

                    @Override
                    public void onSuccess() {
                        L.e("loadSkinSuccess");
                        Toast.makeText(getApplicationContext(), "切换成功", Toast.LENGTH_SHORT).show();
//                        setNightSkinBtn.setText("黑色幻想(当前)");
//                        setOfficalSkinBtn.setText("官方默认");
//                        isOfficalSelected = false;
                    }

                    @Override
                    public void onFailed() {
                        L.e("loadSkinFail");
                        Toast.makeText(getApplicationContext(), "切换失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
