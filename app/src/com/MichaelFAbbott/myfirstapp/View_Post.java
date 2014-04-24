package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.myfirstapp.MainActivityActionBar.PlaceholderFragment;
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



public class View_Post extends ViewWithActivityBar {
	
	
	
	private AttemptController controller;
	
	Button getNextPost;
	TextView textView;
    
	EditText threadID, postContent, userID, userName;
    
	Button submit;
    
	int entry = 1;
	
	
	
	
	
	public View_Post() {
		//nothing?
	}
	
	
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		
		
		getNextPost = (Button) findViewById(R.id.getNextPost1);
		
		textView = (TextView) findViewById(R.id.statusText1);
		
		threadID     =   (EditText) findViewById( R.id.username1 );
		postContent  =   (EditText) findViewById(R.id.password);
		userID       =   (EditText) findViewById(R.id.userID);
		userName     =   (EditText) findViewById(R.id.userName);
		
		submit       =   (Button) findViewById(R.id.submit1);
		
		this.getNextPost.setOnClickListener(this);
		
		this.updateTextView("hi michael, VIEW_POST");
		
		
		
		
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
		
		int source = viewEvent.getId();
		
		//getNextPost button was pressed
		if (source == R.id.getNextPost1)
		{
			this.controller.processNextPostEvent();
		}
		
		//submit button was pressed
		else if (source == R.id.submit1)
		{
			this.controller.processSubmitEvent();
		}
	}
	
	@Override
	public void updateTextView(String show) {
		this.textView.setText( show );
	}
	
	
}
