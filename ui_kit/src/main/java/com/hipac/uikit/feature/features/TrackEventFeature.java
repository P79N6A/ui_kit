package com.hipac.uikit.feature.features;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.hipac.uikit.UIKitConfig;
import com.hipac.uikit.feature.callback.CanvasCallback;
import com.hipac.uikit.feature.callback.ClickCallback;
import com.taobao.uikit.R;

public class TrackEventFeature extends AbsFeature<View> implements ClickCallback, CanvasCallback {

    private String trackName;

    private String trackCode;

    private Paint paint;

    private RectF rectF;

    @Override
    public void afterPerformClick() {
        Log.d("TrackEventFeature", "trackName : " + trackName + " , trackCode : " + trackCode);
    }

    @Override
    public void afterDraw(Canvas canvas) {
        if (!UIKitConfig.getInstance().isHotMapEnable()) {
            return;
        }
        int width = mHost.getMeasuredWidth();
        int height = mHost.getMeasuredHeight();
        if (rectF == null) {
            rectF = new RectF(1, 1, width - 1, height - 1);
        }
        paint.setColor(0x4D000000);
        canvas.drawRect(rectF, paint);
        String text = "PV/UV";
        paint.setColor(Color.WHITE);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float distance = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        float baseline = height / 2.F + distance;
        canvas.drawText(text, width / 2.F, baseline, paint);
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
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                12.F, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.CENTER);
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

    @Override
    public void beforePerformClick() {

    }

    @Override
    public void beforePerformLongClick() {

    }

    @Override
    public void afterPerformLongClick() {

    }

    @Override
    public void beforeDraw(Canvas canvas) {

    }

    @Override
    public void beforeDispatchDraw(Canvas canvas) {

    }

    @Override
    public void afterDispatchDraw(Canvas canvas) {

    }

    @Override
    public void beforeOnDraw(Canvas canvas) {

    }

    @Override
    public void afterOnDraw(Canvas canvas) {

    }
}
