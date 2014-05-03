package com.MichaelFAbbott.myViewAsSurface5;


import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.myCustomView.Board_Controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class Board_MyView5 extends SurfaceView implements SurfaceHolder.Callback {

		//Thread t = null;
	
		Board_MyThread5 t = null;
	
		SurfaceHolder holder;
		//boolean isItOK = false;
		
		
		private Board_Listener5 listener;
		private GestureDetector gestures;
		
		
		public Board_MyView5(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
			
			t = new Board_MyThread5(this);
			
			
			
			listener = new Board_Listener5(); //but it has no constructor?
			gestures = new GestureDetector( context, listener );
			
		}

		
		
		

		@Override
		public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}

		
		

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			//t.terminateSurface();
			t.pause();
		}
		
		public void surfaceRestart() {
			if (t != null) {
				//t.restartSurface();
				t.resume();
			}
		}
		
		
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			
			gestures.onTouchEvent( event );
			
			invalidate();
			
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




