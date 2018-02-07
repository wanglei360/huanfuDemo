package com.skin_library.listener;

import android.view.View;

import com.skin_library.entity.DynamicAttr;

import java.util.List;

public interface IDynamicNewView {
	void dynamicAddView(View view, List<DynamicAttr> pDAttrs);
}
