package com.example.joboxtest;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import static com.example.util.config.*;

public class MyCircle {
	private Body body;
	int color;
	
	private void drawself(Canvas canvas,Paint paint) {
		// TODO Auto-generated method stub
		Vec2 vec2 = body.getPosition();
		float cx = vec2.x*RATE;
		float cy = vec2.y*RATE;
		
		float radius = ((CircleShape)(body.getShapeList())).getRadius()*RATE;
		paint.setColor(color);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(cx,cy,radius,paint);
		paint.reset();
		
	}

}
