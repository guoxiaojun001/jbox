package com.example.jbox0713;
import org.jbox2d.dynamics.Body;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

//�Զ���ľ�����(��ɫ)
public class MyRectColor extends MyBody{	
	float halfWidth;//���
	float halfHeight;//���
	
	public MyRectColor(Body body,float halfWidth,float halfHeight,int color){
		this.body=body;
		this.halfWidth=halfWidth;
		this.halfHeight=halfHeight;		
		this.color=color;
	}
	
	public void drawSelf(Canvas canvas,Paint paint){ 		  
		paint.setColor(color&0x8CFFFFFF);
		float x=body.getPosition().x*Constant.RATE;
		float y=body.getPosition().y*Constant.RATE;
		float angle=body.getAngle();
	    canvas.save();
	    Matrix m1=new Matrix();
	    m1.setRotate((float)Math.toDegrees(angle),x, y);
	    canvas.setMatrix(m1);
		canvas.drawRect(x-halfWidth, y-halfHeight, x+halfWidth, y+halfHeight, paint); 
		paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);//������������
        paint.setColor(color);
        canvas.drawRect(x-halfWidth, y-halfHeight, x+halfWidth, y+halfHeight, paint); 
        paint.reset();      
        canvas.restore();
	}
}