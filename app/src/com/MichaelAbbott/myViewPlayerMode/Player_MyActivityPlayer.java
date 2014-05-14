package com.MichaelAbbott.myViewPlayerMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelAbbott.myCustomView.Board_View;
import com.MichaelAbbott.myViewAsSurface5.Board_Listener5;
import com.MichaelAbbott.myViewAsSurface5.Board_Model5;
import com.MichaelAbbott.myViewAsSurface5.Board_MyView5;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5;
import com.MichaelAbbott.myViewAsSurface5.View_References5;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.HeldState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.OccupantState;
import com.MichaelAbbott.myViewAsSurface6.Board_Listener6;
import com.MichaelAbbott.myViewAsSurface6.Board_Model6;
import com.MichaelAbbott.myViewAsSurface6.Board_MyView6;
import com.MichaelAbbott.myViewAsSurface6.View_References6;
import com.MichaelAbbott.myfirstapp.AttemptController1;
import com.MichaelAbbott.myfirstapp.AttemptModel1;
import com.MichaelAbbott.myfirstapp.Login_View;
import com.MichaelAbbott.myfirstapp.Post_View;
import com.MichaelAbbott.standards.AttemptController;
import com.MichaelAbbott.standards.AttemptModel;
import com.MichaelAbbott.standards.AttemptView;
import com.MichaelAbbott.standards.ViewWithActivityBar;
import com.MichaelFAbbott.myfirstapp.R;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData.Item;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;



public class Player_MyActivityPlayer extends ViewWithActivityBar implements OnTouchListener, OnItemSelectedListener {
	
	
	Board_MyView6 v;
	
	
	private Board_Model6 model;
	private View_References6 mvcView;
	
	private Board_Listener6 mvcController;
	
	//float x, y;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_exp_player);
		
		
		/**/
		Spinner lolSpinner = (Spinner) findViewById(R.id.look_spinner1);
		ArrayAdapter<CharSequence> lolAdapter = ArrayAdapter.createFromResource(this,
		    R.array.lolSpinner_array, android.R.layout.simple_spinner_item);
		lolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		lolSpinner.setAdapter(lolAdapter);
		lolSpinner.setOnItemSelectedListener(this);
		/**/
		
		
		//lolSpinner.setSelection(position);
		//lolSpinner.s
		//lolAdapter.getItemId(position)
		
		/**/
		Spinner occSpinner = (Spinner) findViewById(R.id.look_spinner2);
		ArrayAdapter<CharSequence> occAdapter = ArrayAdapter.createFromResource(this,
		    R.array.occSpinner_array, android.R.layout.simple_spinner_item);
		occAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		occSpinner.setAdapter(occAdapter);
		occSpinner.setOnItemSelectedListener(this);
		/**/
		
		
		model = new Board_Model6(this);
		model.setDeveloperMode(false);
		
		//mvcController = new Board_Listener5(model);
		
		mvcView = new View_References6();
		
		mvcController = new Board_Listener6(model, mvcView);
		
		mvcView.registerObserver(mvcController);
		model.registerObserver(mvcController);
		
		
		/**/
		mvcView.setSpinner(lolSpinner);
		
		mvcView.setOccSpinner(occSpinner);
		/**/
		
		
		
		
		LinearLayout lolContainer = (LinearLayout) findViewById(R.id.linearContainer);
		//Board_MyView4 lolView = new Board_MyView4(this);
		
		v = new Board_MyView6(this, mvcController); //the view is referenced outside of onCreate()
		
		
		
		ProgressBar lolTopBar = (ProgressBar) findViewById(R.id.look_progressBar1);
		ProgressBar lolBottomBar = (ProgressBar) findViewById(R.id.look_progressBar2);
		
		mvcView.setTopBar(lolTopBar);
		mvcView.setBottomBar(lolBottomBar);
		
		
		//mvcView.updateTopVisibility(0);
		//mvcView.updateBottomVisibility(0);
		mvcView.updateBothVisibility(0);
		
		
		//lolContainer.addView(lolView);
		lolContainer.addView(v);
		
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
		
		//let the thread sleep a bit since this motion loop here is doing a lot of stuff
		//50 -> 20 times per second
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//x = me.getX();
		//y = me.getY();
		
		
		switch (me.getAction()) {
		case MotionEvent.ACTION_DOWN:
			//processDown
			
			//x = me.getX();
			//y = me.getY();
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



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		
		/*
		
		
		Hexagon5 theSelected;
		try {
			theSelected = this.model.getSelected();
			
			
			//tile colors
			if (parent.getId() == R.id.look_spinner1)
			{
				
				
				
				switch ( pos ) {
				case 0: //none
					theSelected.setHeldState(HeldState.NONE);
					break;
				case 1: //blue
					theSelected.setHeldState(HeldState.HOLD_BLUE);
					break;
				case 2: //purple
					theSelected.setHeldState(HeldState.HOLD_PURPLE);
					break;
				case 3: //green
					theSelected.setHeldState(HeldState.HOLD_GREEN);
					break;
				case 4: //yellow
					theSelected.setHeldState(HeldState.HOLD_ORANGE);
					break;
				case 5: //red
					theSelected.setHeldState(HeldState.HOLD_RED);
					break;
				default:
					//return super.onOptionsItemSelected(item);
				}
				
				
				
			}
			//occupant selection
			else if (parent.getId() == R.id.look_spinner2)
			{

				
				
				switch ( pos ) {
				case 0: //none
					theSelected.setOccupantState(OccupantState.NONE);
					break;
				case 1: //beige
					theSelected.setOccupantState(OccupantState.OCC_BEIGE);
					break;
				case 2: //blue
					theSelected.setOccupantState(OccupantState.OCC_BLUE);
					break;
				case 3: //green
					theSelected.setOccupantState(OccupantState.OCC_GREEN);
					break;
				case 4: //pink
					theSelected.setOccupantState(OccupantState.OCC_PINK);
					break;
				case 5: //yellow
					theSelected.setOccupantState(OccupantState.OCC_YELLOW);
					break;
				case 6: //portal blue
					theSelected.setOccupantState(OccupantState.P_BLUE);
					break;
				case 7: //portal green
					theSelected.setOccupantState(OccupantState.P_GREEN);
					break;
				case 8: //portal red
					theSelected.setOccupantState(OccupantState.P_RED);
					break;
				case 9: //portal white
					theSelected.setOccupantState(OccupantState.P_WHITE);
					break;
				case 10: //portal yellow
					theSelected.setOccupantState(OccupantState.P_YELLOW);
					break;
				default:
					//nothing (yet)
				}
				
				
				
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//null pointer exception
		}
		
		//System.err.println(pos);
		
		/**/
		
	}



	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
