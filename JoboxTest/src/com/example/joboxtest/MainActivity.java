package com.example.joboxtest;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
	World world;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AABB worldAABB = new AABB();
		worldAABB.lowerBound.set(-100.0f,-100.0f);
		worldAABB.upperBound.set(100.0f,100.0f);
		
		Vec2 gravity = new Vec2(0.0f,10.0f);
		
		boolean dosleep =true;
		world = new World(worldAABB,gravity,dosleep);
		
		setContentView(new Mysurface(this));
		
	}

}
