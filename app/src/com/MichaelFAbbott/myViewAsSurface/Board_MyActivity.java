package com.MichaelFAbbott.myViewAsSurface;

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



public class Board_MyActivity extends ViewWithActivityBar implements OnTouchListener {
	
	
	Board_MySurfaceView v;
	
	float x, y;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v = new Board_MySurfaceView(this);
		
		
		
		v.setOnTouchListener(this);
		//resource stuff
		x = 0;
		y = 0;
		
		
		
		setContentView(v);
	}
	
	
	
	@Override
	protected void onPause() {
		
		//super.onPause();
		//v.pause();
		
		if (v != null) {
			v.surfaceDestroyed( v.getHolder() );
		}
		
		super.onPause();
	}
	
	
	@Override
	protected void onResume() {
		
		//super.onResume();
		//v.resume();
		
		if (v != null) {
			v.surfaceRestart();
		}
		
		super.onPause();
	}
	
	
	
	
	
	
	
	
	@Override
	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		
		//let the thread sleep a bit since this motion loop here is doing a lot of stuff
		//50 -> 20 times per second
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//x = me.getX();
		//y = me.getY();
		
		
		switch (me.getAction()) {
		case MotionEvent.ACTION_DOWN:
			//processDown
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			//processUp
			break;
		case MotionEvent.ACTION_MOVE:
			//process~Drag
			break;
		}
		
		
		
		//return false;
		
		//true allows you to handle multiple motion events instead of cutting off after one
		return true;
	}
	
	
	
	
	
}
