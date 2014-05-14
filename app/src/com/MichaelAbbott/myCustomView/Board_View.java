package com.MichaelAbbott.myCustomView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelAbbott.myfirstapp.AttemptController1;
import com.MichaelAbbott.myfirstapp.AttemptModel1;
import com.MichaelAbbott.standards.AttemptController;
import com.MichaelAbbott.standards.AttemptModel;
import com.MichaelAbbott.standards.AttemptView;
import com.MichaelAbbott.standards.ViewWithActivityBar;
import com.MichaelFAbbott.myfirstapp.R;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Board_View extends ViewWithActivityBar implements AttemptView {
	
	
	
	private AttemptController controller;
	
	Board_CustomView mCustomDrawableView;
	
	
	private Vibrator haptic;
	
	
	
	
	
	
	public Board_View() {
		//nothing?
	}
	
	
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		haptic = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		
		
		//replaces DisplayManager
		mCustomDrawableView = new Board_CustomView(this, haptic);
    	
    	setContentView(mCustomDrawableView);
		
		
		
		AttemptModel1 model = new AttemptModel1();
		AttemptController controller = new AttemptController1(model, this);
		this.registerObserver(controller);
	}
	
	
	@Override
	public void registerObserver(AttemptController controller) {
		this.controller = (AttemptController1) controller;
	}
	
	
	
	@Override
	public void onClick(View viewEvent) {
		//nothing
	}
	
	@Override
	public void updateTextView(String show) {
		//nothing
	}
	
	
}
