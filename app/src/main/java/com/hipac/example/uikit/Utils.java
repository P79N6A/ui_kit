package com.hipac.example.uikit;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

final class Utils {

    static void requireInvalidate(Activity activity) {
        if (activity == null) {
            return;
        }
        requireInvalidate(activity.findViewById(android.R.id.content));
    }


    private static void requireInvalidate(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            view.invalidate();
            return;
        }
        for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
            View child = ((ViewGroup) view).getChildAt(i);
            requireInvalidate(child);
        }
    }

}
