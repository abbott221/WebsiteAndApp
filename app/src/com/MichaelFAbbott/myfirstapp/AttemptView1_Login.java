package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.myfirstapp.MainActivityActionBar.PlaceholderFragment;
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



public class AttemptView1_Login extends Activity implements AttemptView {
	
	
	private AttemptController1 controller;
	
	
	
	
	TextView status;
	
	EditText userName, passWord;
    
	Button submit;
    
	
	
	
	
	public AttemptView1_Login() {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		
		//onCreate is the new constructor for android?
		
	}
	
	

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        //@Bad
        //circumvent NetworkOnMainThreadException
        //doing networking on main thread is bad because the whole thread waits for the response
        //implement Async task later
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //@Bad
        
        
        

        
        
        
        status       =   (TextView) findViewById(R.id.statusText1);
        
        userName     =   (EditText) findViewById( R.id.username1 );
        passWord     =   (EditText) findViewById(R.id.password1);
        
        submit       =   (Button) findViewById(R.id.submit1);
        
        
        
        

		//this.getNextPost.setOnClickListener(this);
		this.submit.setOnClickListener(this);
        //submit.setOnClickListener(new MyOnClickListener(this));
		
		
		
        
        
        
        this.updateTextView("Login below (username, password)");
        
        
        
        
        
        
        //MOVE MAIN METHOD TO HERE?
        //properly register the observer???
        /**
         * 
         * MAIN METHOD GOES HERE?
         * 
         * properly register the observer
         * 
         */
        
        //Model and controller should be passed in as parameters?
        
        
        AttemptModel1 model = new AttemptModel1();
        AttemptController1 controller = new AttemptController1(model, this);
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
    	
        switch (item.getItemId()) {
            case R.id.action_settings:
                //openSearch(); for search activity in example code
            	//Intent i = new Intent(getBaseContext(), AttemptView1.class);
                //startActivity(i);
                return true;
            case R.id.action_login:
            	//Intent i = new Intent(getBaseContext(), AttemptView1.class);
                //startActivity(i);
                return true;
            case R.id.action_board:
                //composeMessage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        
        //return super.onOptionsItemSelected(item);
    }

    
    
    
    
    
    
    @Override
    public void registerObserver(AttemptController controller) {

        this.controller = (AttemptController1) controller;
        
        //that component hasn't been created yet, that happens on the intent
        //this.updateTextView("hi michael 2");

    }



	@Override
	public void onClick(View viewEvent) {
		// TODO Auto-generated method stub

		
		//Object source = event.getSource();
		
		//returns int
		int source = viewEvent.getId();
		//int source = viewEvent.getComponent
		
		
		//getNextPost button
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
		// TODO Auto-generated method stub
		
		this.submit.setText( show );
		
	}
	
	



}
