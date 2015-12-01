package com.example.hp.youarehere.utilities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by ahmedtarek on 11/30/15.
 */
public class CustomPager extends ViewPager {

    public CustomPager(Context context) {
        super(context);
    }

    public CustomPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        boolean wrapWidth = View.MeasureSpec.getMode(widthMeasureSpec) == View.MeasureSpec.AT_MOST;

        final View tab = getChildAt(0);
        int height = getMeasuredHeight();
        int tabWidth = tab.getMeasuredWidth();

        if (wrapWidth) {
            // Keep the current measured width.
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        }

        int fragmentWidth = measureFragment(((Fragment) getAdapter().instantiateItem(this, getCurrentItem())).getView());
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(tabWidth + fragmentWidth + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics()), MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int measureFragment(View view) {
        if (view == null)
            return 0;

        view.measure(0, 0);
        return view.getMeasuredWidth();
    }
}