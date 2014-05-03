package com.MichaelFAbbott.standards;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.customView.Strategy;
import com.MichaelFAbbott.myCustomView.Board_View;
import com.MichaelFAbbott.myViewAsSurface.Board_MyActivity;
import com.MichaelFAbbott.myViewAsSurface2.Board_MyActivity2;
import com.MichaelFAbbott.myViewAsSurface3.Board_MyActivity3;
import com.MichaelFAbbott.myViewAsSurface4.Board_MyActivity4;
import com.MichaelFAbbott.myViewAsSurface5.Board_MyActivity5;
import com.MichaelFAbbott.myfirstapp.AttemptController1;
import com.MichaelFAbbott.myfirstapp.AttemptModel1;
import com.MichaelFAbbott.myfirstapp.Login_View;
import com.MichaelFAbbott.myfirstapp.Post_View;
import com.MichaelFAbbott.myfirstapp.R;
import com.MichaelFAbbott.standards.AttemptController;
import com.MichaelFAbbott.standards.AttemptModel;
import com.MichaelFAbbott.standards.AttemptView;

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



public class ViewWithActivityBar extends ActionBarActivity implements AttemptView {

	private AttemptController controller;
	
	public ViewWithActivityBar() {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		
		//onCreate is the new constructor for android?
		
	}
	
	
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		AttemptModel1 model = new AttemptModel1();
		AttemptController controller = new AttemptController1(model, this);
		this.registerObserver(controller);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		//call processActionBarSelection to start new intent?
		
		Intent i;
		
		switch (item.getItemId()) {
		case R.id.action_settings:
			//openSearch(); for search activity in example code
			//Intent i = new Intent(getBaseContext(), AttemptView1.class);
			//startActivity(i);
			return true;
		case R.id.action_login:
			i = new Intent(getBaseContext(), Login_View.class);
			startActivity(i);
			return true;
		case R.id.action_posts:
			i = new Intent(getBaseContext(), Post_View.class);
			startActivity(i);
			return true;
		case R.id.action_board:
			//composeMessage();
			i = new Intent(getBaseContext(), Board_View.class);
			startActivity(i);
			return true;
		case R.id.action_experiment:
			//composeMessage();
			//i = new Intent(getBaseContext(), Board_MyActivity2.class);
			i = new Intent(getBaseContext(), Board_MyActivity5.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
		//return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public void registerObserver(AttemptController controller) {
		this.controller = (AttemptController1) controller;
	}
	
	
	
	
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateTextView(String show) {
		// TODO Auto-generated method stub
		
	}
	
	



}
