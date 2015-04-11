package com.example.jbox0713;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class MyCircle extends MyBody {
	float radius;
	
	public MyCircle(Body body,int color,float  radius) {
		this.body = body;
		this.color = color;
		this.radius = radius;
	}

	@Override
	public void drawSelf(Canvas canvas, Paint paint) {
		Vec2 v = body.getPosition();
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(v.x*Constant.RATE, v.y*Constant.RATE, radius, paint);
		//在填充的园外部 画一个黑色轮廓线。
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(1);
		paint.setColor(Color.BLACK);
		canvas.drawCircle(v.x*Constant.RATE, v.y*Constant.RATE, radius, paint);
		paint.reset();
	}
}
