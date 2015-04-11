package com.example.jbox0713;

import org.jbox2d.collision.shapes.CircleDef;
import org.jbox2d.collision.shapes.PolygonDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

public class Box2dUtil {
	public static MyBody createBox(
			float x,//x坐标
			float y,//y坐标
		    float halfWidth,//半宽  
		    float halfHeight,//半高 
	        boolean isStatic,//是否为静止的
	        World world,//世界
	        int color//颜色
	    )
		{    
			//创建多边形描述对象
			PolygonDef shape = new PolygonDef();   
			//设置密度
			if(isStatic)
			{
				shape.density = 0;
			}   
			else
			{
				shape.density = 1.0f;
			}   
			//设置摩擦系数
			shape.friction = 0.0f;   
			//设置能量损失率（反弹）
			shape.restitution = 1.0f;   
			shape.setAsBox(halfWidth/Constant.RATE, halfHeight/Constant.RATE);//矩形的宽高
			//创建刚体描述对象   
			BodyDef bodyDef = new BodyDef();
			//设置位置
			bodyDef.position.set(x/Constant.RATE, y/Constant.RATE);
			//在世界中创建刚体
			Body bodyTemp= world.createBody(bodyDef); 
			//指定刚体形状
			bodyTemp.createShape(shape);   
			bodyTemp.setMassFromShapes(); //根据现状计算质量
			
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
