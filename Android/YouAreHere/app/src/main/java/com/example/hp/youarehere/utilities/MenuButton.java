package com.example.hp.youarehere.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ahmedtarek on 12/1/15.
 */
public class MenuButton extends View {


    public MenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p1 = new Paint();
        p1.setColor(Color.YELLOW);

        canvas.drawRect(0f, 0f, 10f, 10f, p1);
        p1.setColor(Color.BLACK);
        canvas.drawLine(0.3f, 0.6f, 1.7f, 0.6f, p1);
        canvas.drawLine(0.3f, 1.2f, 1.7f, 1.2f, p1);
    }
}
