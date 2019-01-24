package com.hipac.uikit.feature.features;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hipac.uikit.feature.callback.ClickCallback;
import com.taobao.uikit.R;

public class TrackEventFeature extends AbsFeature<View> implements ClickCallback {

    private String trackName;

    private String trackCode;

    @Override
    public void beforePerformClick() {

    }

    @Override
    public void afterPerformClick() {
        Log.d("TrackEventFeature", "trackName : " + trackName + " , trackCode : " + trackCode);
    }

    @Override
    public void beforePerformLongClick() {

    }

    @Override
    public void afterPerformLongClick() {

    }

    @Override
    public void constructor(Context context, AttributeSet attrs, int defStyle) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TrackEventFeature);
            if (a != null) {
                trackName = a.getString(R.styleable.TrackEventFeature_uik_trackName);
                trackCode = a.getString(R.styleable.TrackEventFeature_uik_trackCode);
                a.recycle();
            }
        }
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
    }
}
