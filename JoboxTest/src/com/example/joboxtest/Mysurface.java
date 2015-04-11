package com.example.joboxtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
//æ≤Ã¨µº»Î
import static com.example.util.config.*;

public class Mysurface extends SurfaceView implements Callback ,Runnable{

	MainActivity activity;
	SurfaceHolder holder;
	boolean flag = true;

	public Mysurface(Context context){
		super(context);
		holder = getHolder();
		holder.addCallback(this);
		test();

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		flag = false;

	}

	@Override
	public void run() {
		while(flag){
			activity.world.step(TIME_STEP, RATE);
			Canvas canvas = holder.lockCanvas();
			if(canvas != null){
				repaint(canvas);
				holder.unlockCanvasAndPost(canvas);
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				holder.unlockCanvasAndPost(canvas);
				
			}
		}

	}

	private void repaint(Canvas canvas) {
		
		canvas.drawColor(Color.BLUE);
		return;

	}

}
