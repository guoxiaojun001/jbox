package com.example.jbox0713;

import org.jbox2d.dynamics.Body;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class MyBody {
	protected Body body;
	protected int color;
	public abstract void drawSelf(Canvas canvas,Paint paint);
}
