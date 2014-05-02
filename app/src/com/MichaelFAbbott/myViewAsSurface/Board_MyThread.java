

package com.MichaelFAbbott.myViewAsSurface;

import android.graphics.Canvas;
import android.view.SurfaceHolder;



public class Board_MyThread implements Runnable {
	
	
	Thread t = null;
	SurfaceHolder holder;
	boolean isItOK = false;
	
	private Board_MySurfaceView _panel;
	
	private Canvas _c;
	//volatile Thread t;
	
	public Board_MyThread(Board_MySurfaceView panel) {
		
		holder = panel.getHolder();
		_panel = panel;
		
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
		return holder;
	}
	
	
	
  /*
  @Override
  public void run() {
      while (!Thread.currentThread().isInterrupted()) {
          try {
           _c = _holder.lockCanvas(null);
              if (_c == null){
                _holder = _panel.getHolder();
              } else {
               synchronized (_holder) {
                _panel.updatePhysics();
                   _panel.onDraw(_c);
               }
              }   
          } finally {
              if (_c != null) {
                  _holder.unlockCanvasAndPost(_c);
              }
          }
      }
     }
  /**/
	
	
	
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
  
  
  
  
 }
 