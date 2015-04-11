package com.example.util;

import org.jbox2d.collision.shapes.CircleDef;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import com.example.joboxtest.MyCircle;
import static com.example.util.config.*;

public class Box2DUtil {
	public static MyCircle createCircle(World world,float cx,
			float cy,float radius,int color) {
		// TODO Auto-generated method stub
		CircleDef circledef = new CircleDef();
		circledef.density = 1.0f;
		circledef.friction = 0.0f;
		circledef.restitution = 1.0f;
		circledef.radius = radius/RATE;
		
		BodyDef bodydef = new BodyDef();
		bodydef.position.set(cx/RATE, cy/RATE);
		
		Body body = world.createBody(bodydef);
		body.createShape(circledef);
		body.setMassFromShapes();
		
		return null;

	}

}
