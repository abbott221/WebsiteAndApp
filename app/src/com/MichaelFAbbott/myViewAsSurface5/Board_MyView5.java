package com.MichaelFAbbott.myViewAsSurface5;


import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.myCustomView.Board_Controller;
import com.MichaelFAbbott.myCustomView.Board_Model;
import com.MichaelFAbbott.myCustomView.Hexagon;
import com.MichaelFAbbott.myfirstapp.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
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
		
		
		//private Context lolContext;
		//private Drawable blank;
		//private Bitmap lolBitmap;
		
		private Bitmap tAutumn;
		private Bitmap tDirt;
		private Bitmap tGrass;
		private Bitmap tLava;
		private Bitmap tMagic;
		private Bitmap tRock;
		private Bitmap tSand;
		private Bitmap tSnow;
		private Bitmap tStone;
		private Bitmap tWater;
		
		
		
		private Board_Model5 model;
		
		
		
		
		public Board_MyView5(Context context, Board_Listener5 newController) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
			
			t = new Board_MyThread5(this, newController);
			
			
			//pass this to the other stuff
			//model = new Board_Model5();
			//model = activityModel;
			
			
			
			
			//listener = new Board_Listener5(model); //but it has no constructor?
			listener = newController;
			model = newController.getModel();
			
			gestures = new GestureDetector( context, listener );
			
			
			
			//lolContext = context;
			
			//blank = context.getResources().getDrawable( R.drawable.tile_sand_full );
			//blank.setBounds(-50, -50, 50, 50);
			
			//Bitmap mBitmap = Bitmap.createScaledBitmap( R.drawable.field_1, 250, 250, boolean filter);
			
			Resources res = context.getResources();
			tAutumn = BitmapFactory.decodeResource(res, R.drawable.tile_autumn_full);
			tDirt = BitmapFactory.decodeResource(res, R.drawable.tile_dirt_full);
			tGrass = BitmapFactory.decodeResource(res, R.drawable.tile_grass_full);
			tLava = BitmapFactory.decodeResource(res, R.drawable.tile_lava_full);
			tMagic = BitmapFactory.decodeResource(res, R.drawable.tile_magic_full);
			tRock = BitmapFactory.decodeResource(res, R.drawable.tile_rock_full);
			tSand = BitmapFactory.decodeResource(res, R.drawable.tile_sand_full);
			tSnow = BitmapFactory.decodeResource(res, R.drawable.tile_snow_full);
			tStone = BitmapFactory.decodeResource(res, R.drawable.tile_stone_full);
			tWater = BitmapFactory.decodeResource(res, R.drawable.tile_water_full);
			
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
		
		
		
		public void updateTiles() {
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					Hexagon5 current = this.model.getHexagon(i, j);
					
					current.updateSelf();
					
				}
			}
			
			
		}
		
		
		//"process draw event"
		public void drawSurface(Canvas canvas) {
			/*
			//Canvas c = holder.lockCanvas();
			
			//draw on canvas
			//c.drawARGB(255, 150, 150, 10);
			
			Paint paintFill = new Paint();
			//paintFill.setColor(0xff74AC23);
			paintFill.setColor( android.graphics.Color.RED );
			
			paintFill.setStyle( Paint.Style.FILL );
			
			canvas.drawCircle(300, 300, 100, paintFill);
			
			//holder.unlockCanvasAndPost(c);
			/**/
			
			canvas.drawColor(Color.BLACK);
			
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					Hexagon5 current = this.model.getHexagon(i, j);
					
					current.drawSelf2(canvas, tStone);
					
				}
			}
			
			//canvas.save();
			//canvas.drawBitmap(lolBitmap, 100, 100, new Paint());
			//canvas.restore();
			
			
			
			//canvas.save();
			//canvas.translate( 200, 200 );
			//blank.draw(canvas);
			
			//canvas.drawColor(Color.BLACK);
			//canvas.drawBitmap(lolBitmap, 100, 100, new Paint());
			
			//blank.draw(canvas);
			
			//canvas.drawB
			
			//canvas.restore();
			
			
		}
		
		
		
	}




