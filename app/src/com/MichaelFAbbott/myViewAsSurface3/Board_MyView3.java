/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.MichaelFAbbott.myViewAsSurface3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;


/**
 * View that draws, takes keystrokes, etc. for a simple LunarLander game.
 * 
 * Has a mode which RUNNING, PAUSED, etc. Has a x, y, dx, dy, ... capturing the
 * current ship physics. All x/y etc. are measured with (0,0) at the lower left.
 * updatePhysics() advances the physics based on realtime. draw() renders the
 * ship, and does an invalidate() to prompt another draw() as soon as possible
 * by the system.
 */
class Board_MyView3 extends SurfaceView implements SurfaceHolder.Callback {
    
	
    /** Handle to the application context, used to e.g. fetch Drawables. */
    private Context mContext;

    /** Pointer to the text view to display "Paused.." etc. */
    private TextView mStatusText;

    /** The thread that actually draws the animation */
    private Board_MyThread3 thread;
    
    private boolean isItOK = false;

    public Board_MyView3(Context context) {
        super(context);

        // register our interest in hearing about changes to our surface
        SurfaceHolder holder = getHolder();
        
        holder.addCallback(this);

        // create thread only; it's started in surfaceCreated()
        
        
        thread = new Board_MyThread3(this);
        
        /*
        thread = new LunarThread(holder, context, new Handler() {
            @Override
            public void handleMessage(Message m) {
                mStatusText.setVisibility(m.getData().getInt("viz"));
                mStatusText.setText(m.getData().getString("text"));
            }
        });
        /**/

        //setFocusable(true); // make sure we get key events
    }

    /**
     * Fetches the animation thread corresponding to this LunarView.
     * 
     * @return the animation thread
     */
    public Board_MyThread3 getThread() {
        return thread;
    }

    /**
     * Installs a pointer to the text view used for messages.
     */
    
    /*
    public void setTextView(TextView textView) {
        mStatusText = textView;
    }
    /**/

    /* Callback invoked when the surface dimensions change. */
    
    
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        //thread.setSurfaceSize(width, height);
    }
    

    /*
     * Callback invoked when the Surface has been created and is ready to be
     * used.
     */
    public void surfaceCreated(SurfaceHolder holder) {
        // start the thread here so that we don't busy-wait in run()
        // waiting for the surface to be created
        
    	//thread.setRunning(true);
        //thread.start();
        
        //thread.restartSurface();
        
        isItOK = true;
		//thread = new Thread(this);    //"this" is where to find run()
		thread = new Board_MyThread3(this);    //"this" is where to find run()
		thread.start();               //call run() in "this"
    }

    /*
     * Callback invoked when the Surface has been destroyed and must no longer
     * be touched. WARNING: after this method returns, the Surface/Canvas must
     * never be touched again!
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        // we have to tell thread to shut down & wait for it to finish, or else
        // it might touch the Surface after we return and explode
        
    	//boolean retry = true;
        //thread.setRunning(false);
        //while (retry) {
        //    try {
        //        thread.join();
        //        retry = false;
        //    } catch (InterruptedException e) {
        //    }
        //}
        
        
        //thread.terminateSurface();
        
        
        isItOK = false;
		while (true) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}
		thread = null;
        
        
    }
}