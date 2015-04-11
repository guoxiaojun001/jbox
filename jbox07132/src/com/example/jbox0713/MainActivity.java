package com.example.jbox0713;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.AABB;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	World world;
	List<MyBody> bodys = new ArrayList<MyBody>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//没有title bar ，在setContentView之前调用
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//设置全屏，屏幕方向
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,                
				WindowManager.LayoutParams. FLAG_FULLSCREEN); 
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //竖屏 

		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(outMetrics);

		Constant.screenW = outMetrics.widthPixels;
		Constant.screenH = outMetrics.heightPixels;

		AABB aabb = new AABB();//轴对齐，左右和y平行，上下和x平行
		aabb.lowerBound.set(-100.0f, -100.0f);
		aabb.upperBound.set(100.0f, 100.0f);

		Vec2 gravity = new Vec2(5.0f, 5.0f);

		//第三个参数：不模拟不活动的机构,提高性能
		boolean doSleep = true;
		world = new World(aabb, gravity, doSleep);
		float r = 20;//小球直径
		MyBody cirle = Box2dUtil.createCircle(world, Constant.screenW/2-r/2, r/2+30, r/2, Color.RED);
		cirle.body.setLinearVelocity(new Vec2(0f,10f));//设置速度
		bodys.add(cirle);
		
		//创建4周
		final int kd=10;//宽度或高度
		MyBody mrc=Box2dUtil.createBox(kd/4, Constant.screenH/2, kd/4, Constant.screenH/2, true,world,0xFFe6e4FF);
		bodys.add(mrc);
		mrc=Box2dUtil.createBox(Constant.screenW-kd/4, Constant.screenH/2, kd/4, Constant.screenH/2, true,world,0xFFe6e4FF);
		bodys.add(mrc);
		mrc=Box2dUtil.createBox(Constant.screenW/2, kd/4, Constant.screenW/2, kd/4, true,world,0xFFe6e4FF);
		bodys.add(mrc);
		mrc=Box2dUtil.createBox(Constant.screenW/2, Constant.screenH-kd/4, Constant.screenW/2, kd/4, true,world,0xFFe6e4FF);
		bodys.add(mrc);
		
		//三角形
		MyBody traingle =  Box2dUtil.createBox(x, y, world, color);
		
		setContentView(new MySurfaceView(this));
	}
	
}
