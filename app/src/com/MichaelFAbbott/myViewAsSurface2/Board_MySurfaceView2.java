package com.MichaelFAbbott.myViewAsSurface2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Board_MySurfaceView2 extends SurfaceView implements Runnable {

		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;
		
		public Board_MySurfaceView2(Context context) {
			super(context);
			
			holder = getHolder();
		}

		@Override
		public void run() {
			
			while (isItOK == true) {
				//perform canvas drawing
				
				//check if holder (and surface?) are available
				
				if (!holder.getSurface().isValid()) {
					continue;
				}
				
				// Create/Setup canvas
				Canvas c = holder.lockCanvas();
				
				//draw on canvas
				//c.drawARGB(255, 150, 150, 10);
				
				this.updatePhysics();
				this.drawSurface(c);
				
				
				holder.unlockCanvasAndPost(c);
				
			}
		}
		
		public void pause() {
			
			isItOK = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}
		
		public void resume() {
			
			isItOK = true;
			t = new Thread(this);    //"this" is where to find run()
			t.start();               //call run() in "this"
		}
		
	
		public void updatePhysics() {
			//
		}
		
		public void drawSurface(Canvas canvas) {
			//Canvas c = holder.lockCanvas();
			
			//draw on canvas
			//c.drawARGB(255, 150, 150, 10);
			
			Paint paintFill = new Paint();
			//paintFill.setColor(0xff74AC23);
			paintFill.setColor( android.graphics.Color.BLUE );
			
			paintFill.setStyle( Paint.Style.FILL );
			
			canvas.drawCircle(300, 300, 100, paintFill);
			
			//holder.unlockCanvasAndPost(c);
		}
	
}


