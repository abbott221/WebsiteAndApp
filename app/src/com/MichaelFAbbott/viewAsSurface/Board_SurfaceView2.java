package com.MichaelFAbbott.viewAsSurface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.myfirstapp.AttemptController1;
import com.MichaelFAbbott.myfirstapp.AttemptModel1;
import com.MichaelFAbbott.myfirstapp.R;
import com.MichaelFAbbott.standards.AttemptController;
import com.MichaelFAbbott.standards.AttemptModel;
import com.MichaelFAbbott.standards.AttemptView;
import com.MichaelFAbbott.standards.ViewWithActivityBar;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Board_SurfaceView2 extends Activity implements OnTouchListener {
	
	
	OurView v;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		
		v.setOnTouchListener(this);
		
		setContentView(v);
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}
	
	
	
	
	
	public class OurView extends SurfaceView implements Runnable {

		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;
		
		public OurView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
		}

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
				Canvas c = holder.lockCanvas();
				
				//draw on canvas
				c.drawARGB(255, 150, 150, 10);
				
				holder.unlockCanvasAndPost(c);
				
			}
		}
		
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
		
	}





	@Override
	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
