

package com.MichaelFAbbott.myViewAsSurface3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;



public class Board_MyThread3 extends Thread {
	
	
	Thread t = null;
	SurfaceHolder _holder;
	boolean isItOK = false;
	
	
	
	
	
	
	private Board_MyView3 _view;
	
	private Canvas _c;
	//volatile Thread t;
	
	
	
	
	
	private boolean mRun = false;
	
	
	
	
	
	
	
	public Board_MyThread3(Board_MyView3 newView) {
		
		_holder = newView.getHolder();
		_view = newView;
		
		_c = new Canvas();
		
		
		//is the thread start necessary?
		t = new Thread(this);
		t.start();
	}
	
	
	//pause
	public void terminateSurface() {
		//this.t.interrupt();
		
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
	
	
	//resume
	public void restartSurface() {
		//if (t.getState() == Thread.State.TERMINATED) {
		//	t = new Thread(this);
		//	t.start();  // Start a new thread
		//}
		
		
		isItOK = true;
		t = new Thread(this);    //"this" is where to find run()
		t.start();               //call run() in "this"
	}
	
	
	
	public SurfaceHolder getSurfaceHolder() {
		return _holder;
	}
	
	
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(50);
				
				_c = _holder.lockCanvas(null);
				if (_c == null) {
					_holder = _view.getHolder();
				} else {
					synchronized (_holder) {
						//_view.updatePhysics();
						//_view.onDraw(_c);
						doDraw(_c);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
				terminateSurface();
				
				//return; //right?
				
			} finally {
				if (_c != null) {
					_holder.unlockCanvasAndPost(_c);
				}
			}
		}
	}
  
	
	
	private void doDraw(Canvas canvas) {
		Paint paintFill = new Paint();
		//paintFill.setColor(0xff74AC23);
		paintFill.setColor( android.graphics.Color.BLUE );
		
		paintFill.setStyle( Paint.Style.FILL );
		
		canvas.drawCircle(300, 300, 100, paintFill);
	}
	
	
	/*
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isItOK == true) {
			//perform canvas drawing
			
			//check if holder (and surface?) are available
			
			if (!holder.getSurface().isValid()) {
				continue;
			}
			
			// Create/Setup canvas
			_c = holder.lockCanvas();
			//WHAT IS "c" AS OPPOSED TO PRIVATE VARIABLE "_c"???
			
			//draw on canvas
			//c.drawARGB(255, 150, 150, 10);
			_panel.updatePhysics();
			_panel.drawSurface(_c);
			
			holder.unlockCanvasAndPost(_c);
			
		}
	}
  /**/
	
	/*
	public void setRunning(boolean b) {
        mRun = b;
    }
	
	public void pause() {
        synchronized (_holder) {
            //if (mMode == STATE_RUNNING) setState(STATE_PAUSE);
        }
    }
	
	
	public void setSurfaceSize(int width, int height) {
        // synchronized to make sure these all change atomically
        synchronized (_holder) {
        	//
        }
    }
  
	/**/
  
  
 }
 