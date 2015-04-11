package com.example.jbox0713;

import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Callback, Runnable {
	private boolean flag = true;
	private SurfaceHolder holder ;
	private Paint paint;
	private MainActivity activity;
	public MySurfaceView(Context context) {
		super(context);
		paint = new Paint();
		//得到对象
		activity = (MainActivity) context;
		holder = getHolder();
		holder.addCallback(this);
	}

	@Override
	public void run() {
		while(flag){
			//世界开始运转
			activity.world.step(Constant.TIME_STEP, Constant.ITERA);
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
	private void repaint(){
		
		Canvas canvas = holder.lockCanvas();
		if(canvas!=null){
			canvas.drawColor(Color.WHITE);
			doDraw(canvas);
			holder.unlockCanvasAndPost(canvas);
		}
	}
	protected void doDraw(Canvas canvas) {
		//拿到body，然后再画
		List<MyBody> bodys = activity.bodys;
		for(MyBody b:bodys){
			b.drawSelf(canvas, paint);
		}
	}
}
