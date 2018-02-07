package com.skin_library.entity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.skin_library.loader.SkinManager;


public class BackgroundAttr extends SkinAttr {


    @Override
    public void apply(View view) {
        switch (attrValueTypeName) {
            case RES_TYPE_NAME_COLOR:
                view.setBackgroundColor(SkinManager.getInstance().getColor(attrValueRefId));
                break;
            case RES_TYPE_NAME_DRAWABLE:
//                view.setBackgroundColor(SkinManager.getInstance().getColor(attrValueRefId));
                Drawable bg = SkinManager.getInstance().getDrawable(attrValueRefId);
                //  大于16
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                    view.setBackground(bg);
                } else {
                    view.setBackgroundDrawable(bg);
                }
                break;
            case RES_TYPE_NAME_MIPMAP:
                Drawable drawable = SkinManager.getInstance().getResources().getDrawable(attrValueRefId);
                //  大于16
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                    view.setBackground(drawable);
                } else {
                    view.setBackgroundDrawable(drawable);
                }
                break;
        }
//        if (RES_TYPE_NAME_COLOR.equals(attrValueTypeName)) {
//            view.setBackgroundColor(SkinManager.getInstance().getColor(attrValueRefId));
//            Log.i("attr", "_________________________________________________________");
////            Log.i("attr", "apply as color");
//        } else if (RES_TYPE_NAME_DRAWABLE.equals(attrValueTypeName)) {
//            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
//                //  大于16
//                Drawable bg = SkinManager.getInstance().getDrawable(attrValueRefId);
//                view.setBackground(bg);
//            } else {
//                view.setBackgroundColor(SkinManager.getInstance().getColor(attrValueRefId));
//            }

//            Log.i("attr", "_________________________________________________________");
//            Log.i("attr", "apply as drawable");
//            Log.i("attr", "bg.toString()  " + bg.toString());
//
//            Log.i("attr", this.attrValueRefName + " 是否可变换状态? : " + bg.isStateful());
//        }
    }
}
