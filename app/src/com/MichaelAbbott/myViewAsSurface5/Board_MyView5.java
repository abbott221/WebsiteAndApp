package com.MichaelFAbbott.myViewAsSurface5;


import com.MichaelFAbbott.myCustomView.Board_Controller;
import com.MichaelFAbbott.myCustomView.Board_Model;
import com.MichaelFAbbott.myCustomView.Hexagon;
import com.MichaelFAbbott.myViewAsSurface5.Hexagon5.BlockState;
import com.MichaelFAbbott.myfirstapp.R;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class Board_MyView5 extends SurfaceView implements SurfaceHolder.Callback {

		//Thread t = null;
	
		Board_MyThread5 t = null;
	
		SurfaceHolder holder;
		//boolean isItOK = false;
		
		
		private Board_Listener5 listener;
		private GestureDetector touchGestures;
		
		private ScaleGestureDetector scaleGestures;
		
		private boolean scrollInProgress = false;
		private boolean scaleInProgress = false;
		//private boolean scrollOccurred = false;
		
		
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
		
		private Bitmap topGrass;
		private Bitmap topDirt;
		private Bitmap topSand;
		
		
		private Bitmap occBeige;
		private Bitmap occBlue;
		private Bitmap occGreen;
		private Bitmap occPink;
		private Bitmap occYellow;
		
		
		private Bitmap sepiaSky;
		
		
		private Bitmap portalBlue;
		private Bitmap portalGreen;
		private Bitmap portalRed;
		private Bitmap portalWhite;
		private Bitmap portalYellow;
		
		
		
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
			
			touchGestures = new GestureDetector( context, listener );
			
			Board_ScaleListener5 tempScaleListener;
			tempScaleListener = new Board_ScaleListener5(listener.getModel(), listener.getView());
			scaleGestures = new ScaleGestureDetector( context, tempScaleListener );
			
			
			
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
			
			
			
			topGrass = BitmapFactory.decodeResource(res, R.drawable.demo_grass);
			topDirt = BitmapFactory.decodeResource(res, R.drawable.demo_dirt);
			topSand = BitmapFactory.decodeResource(res, R.drawable.demo_sand);
			
			
			
			occBeige = BitmapFactory.decodeResource(res, R.drawable.alien_beige);
			occBlue = BitmapFactory.decodeResource(res, R.drawable.alien_blue);
			occGreen = BitmapFactory.decodeResource(res, R.drawable.alien_green);
			occPink = BitmapFactory.decodeResource(res, R.drawable.alien_pink);
			occYellow = BitmapFactory.decodeResource(res, R.drawable.alien_yellow);
			
			
			sepiaSky = BitmapFactory.decodeResource(res, R.drawable.sepia_sky);
			
			
			portalBlue = BitmapFactory.decodeResource(res, R.drawable.portal_blue);
			portalGreen = BitmapFactory.decodeResource(res, R.drawable.portal_green);
			portalRed = BitmapFactory.decodeResource(res, R.drawable.portal_red);
			portalWhite = BitmapFactory.decodeResource(res, R.drawable.portal_white);
			portalYellow = BitmapFactory.decodeResource(res, R.drawable.portal_yellow);
			
			
			model.registerMyView5(this);
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
		
		
		public void setScrollInProgress(boolean newValue)
		{
			this.scrollInProgress = newValue;
		}
		
		public void setScaleInProgress(boolean newValue)
		{
			this.scaleInProgress = newValue;
		}
		
		
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			scaleGestures.onTouchEvent(event);
			
			if (!scaleGestures.isInProgress())
			{
				touchGestures.onTouchEvent( event );
			}
			//touchGestures.onTouchEvent( event );
			
			
			
			int action = MotionEventCompat.getActionMasked(event);
			
			
			/*
			if (event.getSource() == MotionEvent.ACTION_SCROLL)
			{
				this.scrollInProgress = true;
				System.err.println("scroll in progress");
			}
			/**/
			if (action == MotionEvent.ACTION_UP)
			{
				//System.err.println("up occurred");
				
				if (this.scrollInProgress == true)
				{
					
					if (this.scaleInProgress == true)
					{
						//System.err.println("scroll ended for scale event");
						
						//this.scrollInProgress = false;
						setScrollInProgress(false);
						setScaleInProgress(false);
					}
					else
					{
						//System.err.println("scroll ended for scroll exclusive event");
						
						listener.onScrollEnd();
						
						//this.scrollInProgress = false;
						setScrollInProgress(false);
					}
					
					//System.err.println("scroll ended");
				}
				
				//scroll not in progress (but scale also wouldn't be in progress)
				else
				{
					//never mind
				}
				
				
				
				
			}
			
			/*
			switch(action) {
			case (MotionEvent.ACTION_SCROLL):
				//Log.d(DEBUG_TAG,"Action was DOWN");
				
				break;
			case (MotionEvent.ACTION_DOWN):
				//Log.d(DEBUG_TAG,"Action was DOWN");
				break;
			case (MotionEvent.ACTION_MOVE):
				//Log.d(DEBUG_TAG,"Action was MOVE");
				break;
			case (MotionEvent.ACTION_UP):
				//if (event.g == MotionEvent.ACTION_SCROLL)
				//{
					//
				//}
				//Log.d(DEBUG_TAG,"Action was UP");
				break;
			case (MotionEvent.ACTION_CANCEL):
				//Log.d(DEBUG_TAG,"Action was CANCEL");
				break;
			case (MotionEvent.ACTION_OUTSIDE):
				//Log.d(DEBUG_TAG,"Movement of current screen element");
				break;
			default:
				//return super.onTouchEvent(event);
			}
			/**/
			
			
			
			invalidate();
			
			return true;
		}
		
		
		
		public void updateTiles() {
			
			float mScale;
			float scrollX;
			float scrollY;
			float canvasHeight;
			float canvasWidth;
			float resultX;
			float resultY;
			
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					Hexagon5 current = this.model.getHexagon(i, j);
					
					current.updateSelfColor();
					
					
					//Haskell or lambda expressions would probably be a good idea here
					//I'll look into that sometime...
					
					mScale = this.model.getScale();
					scrollX = this.model.getDisplacementX();
					scrollY = this.model.getDisplacementY();
					canvasHeight = this.model.getCanvasHalfHeight();
					canvasWidth = this.model.getCanvasHalfWidth();
					
					
					
					/*
					resultX = canvasWidth * mScale;
					resultY = canvasHeight * mScale;
					
					resultX += scrollX;
					resultY += scrollY;
					
					resultX += (current.getCenterX() - canvasWidth);
					resultY += (current.getCenterY() - canvasHeight);
					/**/
					
					resultX = canvasWidth;
					resultY = canvasHeight;
					
					resultX += scrollX * mScale;
					resultY += scrollY * mScale;
					
					resultX += (current.getCenterX() - canvasWidth) * mScale;
					resultY += (current.getCenterY() - canvasHeight) * mScale;
					
					
					
					current.setCanvasX(resultX);
					current.setCanvasY(resultY);
					
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
			
			float passScale = this.model.getScale();
			float passX = this.model.getDisplacementX();
			float passY = this.model.getDisplacementY();
			
			
			//make background black
			canvas.drawColor(Color.BLACK);
			
			
			/****************************************/
			
			
			Bitmap drawBlock = sepiaSky;
			
			
			canvas.save(); //SAVE
			
			
			// 0) TRYING THIS WITH PLANNING FOR ONCE
			// edge = [canvasHalf + f(displace)] - [(pic)*f(scale)]
			// edge = [canvasHalf + displace / 2] - [pic * 3(inScale ^ (1/2) )]
			
			/*****************************/
			// 1) MEASUREMENTS
			
			float hCanvasHeight = canvas.getHeight() / 2;
			float hCanvasWidth = canvas.getWidth() / 2;
			
			float hPicHeight = drawBlock.getHeight() / 2;
			float hPicWidth = drawBlock.getWidth() / 2;
			
			float fDisplaceX = passX / 5;
			float fDisplaceY = passY / 5;
			
			//float fScale = (float) Math.pow(passScale, 0.5);
			//fScale *= 3.0;
			float fScale = (float) (passScale * 3.0);
			
			// 1) ENDS
			/*****************************/
			
			
			canvas.translate( hCanvasWidth, hCanvasHeight );
			
			
			// 2) SCALING OF THE PIC FROM CENTER
			
			canvas.scale( fScale, fScale );
			
			// 2) ENDS
			
			
			canvas.translate( fDisplaceX, fDisplaceY );
			
			//canvas.translate( ,  );
			//center is canvas so center - canvas is 0
			
			
			// 3) LINE UP CENTER OF PIC WITH CENTER OF CANVAS
			
			//wait... mixed up x vs. y and height vs. width
			//left edge: x with width, top: y with height
			
			float topEdge = (hCanvasHeight + fDisplaceY) - (hPicHeight * fScale);
			float leftEdge = (hCanvasWidth + fDisplaceX) - (hPicWidth * fScale);
			
			//works so far
			//topEdge = (hCanvasHeight + fDisplaceY) - (hPicHeight);
			//leftEdge = (hCanvasWidth + fDisplaceX) - (hPicWidth);
			
			topEdge = (hCanvasHeight + fDisplaceY) - (hPicHeight);
			leftEdge = (hCanvasWidth + fDisplaceX) - (hPicWidth);
			
			topEdge = -1.0f * hPicHeight;
			leftEdge = -1.0f * hPicWidth;
			
			// 3) ENDS
			
			
			
			
			
			//all calculations done via the edges
			//canvas.translate( passX, passY );
			
			
			
			
			canvas.drawBitmap(drawBlock, leftEdge, topEdge, new Paint() );
			//canvas.drawBitmap(drawOccupant, -wHalf, (-hHalf - 30), paintFill);
			
			
			//canvas.scale( fScale, fScale );
			
			
			
			canvas.restore(); //RESTORE
			
			/****************************************/
			
			Bitmap passBlock = topGrass;
			Bitmap passOccupant = occBeige;
			
			
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					Hexagon5 current = this.model.getHexagon(i, j);
					
					
					/**/
					switch ( current.getOccupantState() ) {
					case NONE:
						//passOccupant = occBeige; //a default, I guess (it won't be drawn)
						break;
					case OCC_BEIGE:
						passOccupant = occBeige;
						break;
					case OCC_BLUE:
						passOccupant = occBlue;
						break;
					case OCC_GREEN:
						passOccupant = occGreen;
						break;
					case OCC_PINK:
						passOccupant = occPink;
						break;
					case OCC_YELLOW:
						passOccupant = occYellow;
						break;
					case P_BLUE:
						passOccupant = portalBlue;
						break;
					case P_GREEN:
						passOccupant = portalGreen;
						break;
					case P_RED:
						passOccupant = portalRed;
						break;
					case P_WHITE:
						passOccupant = portalWhite;
						break;
					case P_YELLOW:
						passOccupant = portalYellow;
						break;
					default:
						//nothing
					}
					/**/
					
					
					switch ( current.getBlockState() ) {
					case NONE:
						//passOccupant = occBeige; //a default, I guess (it won't be drawn)
						break;
					case DIRT:
						passBlock = topDirt;
						break;
					case GRASS:
						passBlock = topGrass;
						break;
					case SAND:
						passBlock = topSand;
						break;
					default:
						//nothing
					}
					
					current.drawSelf(canvas, passBlock, passOccupant, passScale, passX, passY);
					//current.drawSelf(canvas, tDemo);
					
				}
			}
			
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					
					Hexagon5 current = this.model.getHexagon(i, j);
					
					switch ( current.getBlockState() ) {
					case NONE:
						//passOccupant = occBeige; //a default, I guess (it won't be drawn)
						break;
					case DIRT:
						passBlock = topDirt;
						break;
					case GRASS:
						passBlock = topGrass;
						break;
					case SAND:
						passBlock = topSand;
						break;
					default:
						//nothing
					}
					
					//don't draw outline if player and blockstate is none
					if ( !this.model.getDeveloperMode() && current.getBlockState() == BlockState.NONE )
					{
						//don't draw
					}
					else
					{
						current.drawSelf_Outline(canvas, passBlock, passOccupant, passScale, passX, passY);
					}
					
				}
			}
			
			for (int i = 0; i < this.model.getRows(); i++) {
				for (int j = 0; j < this.model.getColumns(); j++) {
					
					Hexagon5 current = this.model.getHexagon(i, j);
					
					switch ( current.getOccupantState() ) {
					case NONE:
						//passOccupant = occBeige; //a default, I guess (it won't be drawn)
						break;
					case OCC_BEIGE:
						passOccupant = occBeige;
						break;
					case OCC_BLUE:
						passOccupant = occBlue;
						break;
					case OCC_GREEN:
						passOccupant = occGreen;
						break;
					case OCC_PINK:
						passOccupant = occPink;
						break;
					case OCC_YELLOW:
						passOccupant = occYellow;
						break;
					case P_BLUE:
						passOccupant = portalBlue;
						break;
					case P_GREEN:
						passOccupant = portalGreen;
						break;
					case P_RED:
						passOccupant = portalRed;
						break;
					case P_WHITE:
						passOccupant = portalWhite;
						break;
					case P_YELLOW:
						passOccupant = portalYellow;
						break;
					default:
						//nothing
					}
					
					current.drawSelf_Occupant(canvas, passBlock, passOccupant, passScale, passX, passY);
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




