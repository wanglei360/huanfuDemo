package com.demo.huanfudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.skin_library.entity.DynamicAttr;
import com.skin_library.listener.IDynamicNewView;
import com.skin_library.listener.ISkinUpdate;
import com.skin_library.loader.SkinInflaterFactory;
import com.skin_library.loader.SkinManager;

import java.util.List;

//import cn.feng.skin.manager.entity.DynamicAttr;
//import cn.feng.skin.manager.listener.IDynamicNewView;
//import cn.feng.skin.manager.listener.ISkinUpdate;
//import cn.feng.skin.manager.loader.SkinInflaterFactory;
//import cn.feng.skin.manager.loader.SkinManager;

/**
 * 创建者：wanglei
 * <p>时间：18/2/5  16:01
 * <p>类描述：
 * <p>修改人：
 * <p>修改时间：
 * <p>修改备注：
 */
public class BaseActivity extends Activity implements ISkinUpdate, IDynamicNewView {
    /**
     * Whether response to skin changing after create
     */
    private boolean isResponseOnSkinChanging = true;

    private SkinInflaterFactory mSkinInflaterFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSkinInflaterFactory = new SkinInflaterFactory();
        getLayoutInflater().setFactory(mSkinInflaterFactory);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SkinManager.getInstance().attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().detach(this);
        mSkinInflaterFactory.clean();
    }

    /**
     * dynamic add a skin view
     *
     * @param view
     * @param attrName
     * @param attrValueResId
     */
    protected void dynamicAddSkinEnableView(View view, String attrName, int attrValueResId){
        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, attrName, attrValueResId);
    }

    protected void dynamicAddSkinEnableView(View view, List<DynamicAttr> pDAttrs){
        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
    }

    final protected void enableResponseOnSkinChanging(boolean enable){
        isResponseOnSkinChanging = enable;
    }

    @Override
    public void onThemeUpdate() {
        if(!isResponseOnSkinChanging){
            return;
        }
        mSkinInflaterFactory.applySkin();
    }

    @Override
    public void dynamicAddView(View view, List<DynamicAttr> pDAttrs) {
        mSkinInflaterFactory.dynamicAddSkinEnableView(this, view, pDAttrs);
    }
}
