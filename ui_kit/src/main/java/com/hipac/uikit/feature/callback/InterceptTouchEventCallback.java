package com.hipac.uikit.feature.callback;

import android.view.MotionEvent;

public interface InterceptTouchEventCallback {
    boolean onInterceptTouchEvent(MotionEvent ev);
}
