package com.MichaelFAbbott.myViewAsSurface4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class Board_MyView4 extends SurfaceView implements SurfaceHolder.Callback {

		//Thread t = null;
	
		Board_MyThread4 t = null;
	
		SurfaceHolder holder;
		boolean isItOK = false;
		
		public Board_MyView4(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
			
			t = new Board_MyThread4(this);
		}

		
		
		

		@Override
		public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder arg0) {
			// TODO Auto-generated method stub
			
		}

		
		

		@Override
		public void surfaceDestroyed(SurfaceHolder arg0) {
			t.terminateSurface();
		}
		
		public void surfaceRestart() {
			if (t != null) {
				t.restartSurface(); 
			}
		}
		
		
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			
			
			return true;
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
			paintFill.setColor( android.graphics.Color.RED );
			
			paintFill.setStyle( Paint.Style.FILL );
			
			canvas.drawCircle(300, 300, 100, paintFill);
			
			//holder.unlockCanvasAndPost(c);
		}
		
		
		
	}




