package com.example.jbox0713;
import org.jbox2d.dynamics.Body;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;

//自定义的矩形类(颜色)
public class MyTraingle extends MyBody
{	
	float[][] point;
	
	public MyTraingle(Body body,float[][] point, int color)
	{
		this.body=body;
		this.color=color;
		this.point = point;
		
	}
	
	public void drawSelf(Canvas canvas,Paint paint)
	{ 		  
		paint.setColor(color&0x8CFFFFFF);
		float x=body.getPosition().x*Constant.RATE;
		float y=body.getPosition().y*Constant.RATE;
		float angle=body.getAngle();
	    canvas.save();
	    Matrix m1=new Matrix();
	    m1.setRotate((float)Math.toDegrees(angle),x, y);
	    
        Path path  = new Path();
        path.moveTo(x+point[0][0], y+point[0][1]);
        path.lineTo(x+point[1][0], y+point[1][1]);
        path.lineTo(x+point[1][0], y+point[1][1]);
        
        paint.reset();      
        canvas.restore();
	}
}
