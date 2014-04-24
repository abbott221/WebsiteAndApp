package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.myfirstapp.MainActivityActionBar.PlaceholderFragment;

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



public class AttemptView1 extends ActionBarActivity implements AttemptView {
	
	
	private AttemptController1 controller;
	
	
	//private final Button getNextPost;
	//private final TextView textView;
    
	//private final EditText threadID, postContent, userID, userName;
    
	//private final Button submit;
	
	Button getNextPost;
	TextView textView;
    
	EditText threadID, postContent, userID, userName;
    
	Button submit;
    
	
	
	//boolean changedText = false;
	int entry = 1;
	
	
	
	
	
	
	
	public AttemptView1() {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		
		//onCreate is the new constructor for android?
		
	}
	
	

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //@Bad
        //circumvent NetworkOnMainThreadException
        //doing networking on main thread is bad because the whole thread waits for the response
        //implement Async task later
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //@Bad
        
        
        

        

		getNextPost = (Button) findViewById(R.id.getNextPost1);
        
        //getNextPost.setOnClickListener(new MyOnClickListener(this));
		this.getNextPost.setOnClickListener(this);
		
		
        textView = (TextView) findViewById(R.id.statusText1);
		
		
		
        threadID     =   (EditText) findViewById( R.id.username1 );
        postContent  =   (EditText) findViewById(R.id.password);
        userID       =   (EditText) findViewById(R.id.userID);
        userName     =   (EditText) findViewById(R.id.userName);
        
        submit       =   (Button) findViewById(R.id.submit1);
         
         

        
        //submit.setOnClickListener(new MyOnClickListener(this));
        this.submit.setOnClickListener(this);
        //submit.s
        //submit.setO
        
        
        
        this.updateTextView("hi michael, ATTEMPT VIEW 2");
        
        
        
        
        
        
        //MOVE MAIN METHOD TO HERE?
        //properly register the observer???
        /**
         * 
         * MAIN METHOD GOES HERE?
         * 
         * properly register the observer
         * 
         */
        
        
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
    public void registerObserver(AttemptController1 controller) {

        this.controller = controller;
        
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
		
		this.textView.setText( show );
		
	}
	
	
	public void updateActionBarView(int id) {
		// TODO Auto-generated method stub
		
		//this.textView.setText( show );
		
		//Intent i = new Intent(getBaseContext(), AttemptView1.class);
        //startActivity(i);
		
	}



}
