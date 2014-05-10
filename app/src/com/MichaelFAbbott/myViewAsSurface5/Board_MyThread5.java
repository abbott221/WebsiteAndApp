

package com.MichaelFAbbott.myViewAsSurface5;

import android.graphics.Canvas;
import android.view.SurfaceHolder;



public class Board_MyThread5 implements Runnable {
	
	
	Thread t = null;
	SurfaceHolder holder;
	boolean isItOK = false;
	
	private Board_MyView5 _panel;
	
	private Board_Listener5 controller;
	
	private Canvas _c;
	//volatile Thread t;
	
	public Board_MyThread5(Board_MyView5 panel, Board_Listener5 newController) {
		
		holder = panel.getHolder();
		_panel = panel;
		
		controller = newController;
		_c = new Canvas();
		
		
		//is the thread start necessary?
		t = new Thread(this);
		t.start();
	}
	
	
	
	
	
	public SurfaceHolder getSurfaceHolder() {
		return holder;
	}
	
	
	
	/*****************************************/
	
	
	public void pause() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		isItOK = true;
		t = new Thread(this);    //"this" is where to find run()
		t.start();               //call run() in "this"
	}
	
	/*******************************************/
	
	
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
			
			
			
			//My phone was getting pretty warm :/
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			if (!holder.getSurface().isValid()) {
				continue;
			}
			
			// Create/Setup canvas
			_c = holder.lockCanvas();
			//WHAT IS "c" AS OPPOSED TO PRIVATE VARIABLE "_c"???
			
			
			Board_Model5 tempM = this.controller.getModel();
			tempM.setCanvasHalfHeight(_c.getHeight() / 2);
			tempM.setCanvasHalfWidth(_c.getWidth() / 2);
			
			
			//draw on canvas
			//c.drawARGB(255, 150, 150, 10);
			_panel.updateTiles();
			_panel.drawSurface(_c);
			
			holder.unlockCanvasAndPost(_c);
			
		}
	}
  
  
  
  
 }
 