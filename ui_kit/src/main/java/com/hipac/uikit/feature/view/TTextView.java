package com.hipac.uikit.feature.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.hipac.uikit.feature.callback.CanvasCallback;
import com.hipac.uikit.feature.callback.ClickCallback;
import com.hipac.uikit.feature.callback.FocusCallback;
import com.hipac.uikit.feature.callback.LayoutCallback;
import com.hipac.uikit.feature.callback.MeasureCallback;
import com.hipac.uikit.feature.callback.ScrollCallback;
import com.hipac.uikit.feature.callback.TouchEventCallback;
import com.hipac.uikit.feature.features.AbsFeature;
import com.hipac.uikit.utils.FeatureList;
import com.hipac.uikit.utils.IFeatureList;


/**
 * TTextView: UIKit's custom TextView
 *
 * @author jiajing
 */
public class TTextView extends AppCompatTextView implements ViewHelper,
		IFeatureList<TextView> {
	private FeatureList<TextView> mFeatureList = new FeatureList<TextView>(this);

	public TTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mFeatureList.init(context, attrs, defStyle);
	}

	public TTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public TTextView(Context context) {
		this(context, null);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof MeasureCallback) {
				((MeasureCallback) feature).beforeOnMeasure(widthMeasureSpec,
						heightMeasureSpec);
			}
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof MeasureCallback) {
				((MeasureCallback) feature).afterOnMeasure(widthMeasureSpec,
						heightMeasureSpec);
			}
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
							int bottom) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof LayoutCallback) {
				((LayoutCallback) feature).beforeOnLayout(changed, left, top,
						right, bottom);
			}
		}
		super.onLayout(changed, left, top, right, bottom);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof LayoutCallback) {
				((LayoutCallback) feature).afterOnLayout(changed, left, top,
						right, bottom);
			}
		}
	}

	@Override
	public void draw(Canvas canvas) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).beforeDraw(canvas);
			}
		}
		super.draw(canvas);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).afterDraw(canvas);
			}
		}

	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).beforeDispatchDraw(canvas);
			}
		}
		super.dispatchDraw(canvas);
		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).afterDispatchDraw(canvas);
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).beforeOnDraw(canvas);
			}
		}

		super.onDraw(canvas);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof CanvasCallback) {
				((CanvasCallback) feature).afterOnDraw(canvas);
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof TouchEventCallback) {
				((TouchEventCallback) feature).beforeOnTouchEvent(event);
			}
		}
		boolean result = super.onTouchEvent(event);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof TouchEventCallback) {
				((TouchEventCallback) feature).afterOnTouchEvent(event);
			}
		}
		return result;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof TouchEventCallback) {
				((TouchEventCallback) feature).beforeDispatchTouchEvent(event);
			}
		}
		boolean result = super.dispatchTouchEvent(event);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof TouchEventCallback) {
				((TouchEventCallback) feature).afterDispatchTouchEvent(event);
			}
		}
		return result;
	}

	@Override
	public boolean performClick() {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof ClickCallback) {
				((ClickCallback) feature).beforePerformClick();
			}
		}
		boolean result = super.performClick();

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof ClickCallback) {
				((ClickCallback) feature).afterPerformClick();
			}
		}
		return result;
	}

	@Override
	public boolean performLongClick() {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof ClickCallback) {
				((ClickCallback) feature).beforePerformLongClick();
			}
		}
		boolean result = super.performLongClick();

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof ClickCallback) {
				((ClickCallback) feature).afterPerformLongClick();
			}
		}
		return result;
	}

	@Override
	public void setMeasuredDimension(long width, long height) {
		super.setMeasuredDimension((int) width, (int) height);
	}

	@Override
	protected void onFocusChanged(boolean gainFocus, int direction,
								  Rect previouslyFocusedRect) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof FocusCallback) {
				((FocusCallback) feature).beforeOnFocusChanged(gainFocus,
						direction, previouslyFocusedRect);
			}
		}
		super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof TouchEventCallback) {
				((FocusCallback) feature).afterOnFocusChanged(gainFocus,
						direction, previouslyFocusedRect);
			}
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof FocusCallback) {
				((FocusCallback) feature)
						.beforeOnWindowFocusChanged(hasWindowFocus);
			}
		}
		super.onWindowFocusChanged(hasWindowFocus);

		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof FocusCallback) {
				((FocusCallback) feature)
						.afterOnWindowFocusChanged(hasWindowFocus);
			}
		}
	}

	@Override
	public void computeScroll() {
		for (AbsFeature<? super TextView> feature : mFeatureList) {
			if (feature instanceof ScrollCallback) {
				((ScrollCallback) feature).beforeComputeScroll();
			}
		}
		super.computeScroll();
		for (int i = mFeatureList.size() - 1; i >= 0; i--) {
			AbsFeature<? super TextView> feature = mFeatureList.get(i);
			if (feature instanceof ScrollCallback) {
				((ScrollCallback) feature).afterComputeScroll();
			}
		}
	}

	@Override
	public <O extends AbsFeature<? super TextView>> O findFeature(
			Class<O> clazz) {
		return mFeatureList.findFeature(clazz);
	}

	@Override
	public boolean removeFeature(Class<? extends AbsFeature<? super TextView>> clazz) {
		return mFeatureList.removeFeature(clazz);
	}

	@Override
	public void clearFeatures() {
		mFeatureList.clearFeatures();
	}

	@Override
	public void init(Context context, AttributeSet attrs, int defStyle) {
		mFeatureList.init(context, attrs, defStyle);
	}

	@Override
	public boolean addFeature(AbsFeature<? super TextView> feature) {
		return mFeatureList.addFeature(feature);
	}
}
