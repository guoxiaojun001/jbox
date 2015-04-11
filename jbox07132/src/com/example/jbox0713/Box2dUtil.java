package com.example.jbox0713;

import org.jbox2d.collision.shapes.CircleDef;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class Box2dUtil {
	public static MyBody createBox(
			float x,//x����
			float y,//y����
		    float halfWidth,//���  
		    float halfHeight,//��� 
	        boolean isStatic,//�Ƿ�Ϊ��ֹ��
	        World world,//����
	        int color//��ɫ
	    )
		{    
			//�����������������
			PolygonDef shape = new PolygonDef();   
			//�����ܶ�
			if(isStatic)
			{
				shape.density = 0;
			}   
			else
			{
				shape.density = 1.0f;
			}   
			//����Ħ��ϵ��
			shape.friction = 0.0f;   
			//����������ʧ�ʣ�������
			shape.restitution = 1.0f;   
			shape.setAsBox(halfWidth/Constant.RATE, halfHeight/Constant.RATE);//���εĿ��
			//����������������   
			BodyDef bodyDef = new BodyDef();
			//����λ��
			bodyDef.position.set(x/Constant.RATE, y/Constant.RATE);
			//�������д�������
			Body bodyTemp= world.createBody(bodyDef); 
			//ָ��������״
			bodyTemp.createShape(shape);   
			bodyTemp.setMassFromShapes(); //������״��������
			
			return new MyRectColor(bodyTemp,halfWidth,halfHeight,color);
		}  
	public static MyBody createCircle(World world,
			float x, 
			float y,
			float radius,
			int color){
		BodyDef bodyDef = new BodyDef();
		bodyDef.position.set(x/Constant.RATE, y/Constant.RATE);
		Body body = world.createBody(bodyDef);
		CircleDef circleDef = new CircleDef();
		circleDef.density = 1.0f;
		circleDef.friction = 0f;
		circleDef.restitution = 1.0f;
		circleDef.radius = radius/Constant.RATE;
		body.createShape(circleDef);
		body.setMassFromShapes();
		return new MyCircle(body,color,radius);
	} 
}
