package com.skin_library.entity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skin_library.loader.SkinManager;
import com.skin_library.util.L;

/**
 * 创建者：wanglei
 * <p>时间：18/2/5  17:18
 * <p>类描述：
 * <p>修改人：
 * <p>修改时间：
 * <p>修改备注：
 */
public class SrcAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof ImageView) {
            ImageView iv = (ImageView) view;
            if("ic_men_selected".equals(attrValueRefName)){
                Log.e("","");
            }
            switch (attrValueTypeName) {
                case RES_TYPE_NAME_COLOR:
                    iv.setImageResource(SkinManager.getInstance().getColor(attrValueRefId));
                    break;
                case RES_TYPE_NAME_DRAWABLE:
                    Drawable drawable = SkinManager.getInstance().getDrawable(attrValueRefId);
                    iv.setImageDrawable(drawable);
                    break;
                case RES_TYPE_NAME_MIPMAP:
                    Drawable drawable1 = SkinManager.getInstance().getResources().getDrawable(attrValueRefId);
                    iv.setImageDrawable(drawable1);
                    break;
            }
        }
    }
}
