package com.MichaelFAbbott.myCustomView;

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
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
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
	
	
	
	
	
	
	public Board_View() {
		//nothing?
	}
	
	
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		
		
		//replaces DisplayManager
		mCustomDrawableView = new Board_CustomView(this);
    	
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