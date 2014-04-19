package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class AttemptView1 extends Activity implements AttemptView {
	
	
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

        

		getNextPost = (Button) findViewById(R.id.button1);
        
        //getNextPost.setOnClickListener(new MyOnClickListener(this));
		this.getNextPost.setOnClickListener(this);
		
		
        textView = (TextView) findViewById(R.id.textView1);
		
		
		
        threadID     =   (EditText) findViewById( R.id.threadID );
        postContent  =   (EditText) findViewById(R.id.postContent);
        userID       =   (EditText) findViewById(R.id.userID);
        userName     =   (EditText) findViewById(R.id.userName);
        
        submit       =   (Button) findViewById(R.id.submit);
         
         

        
        //submit.setOnClickListener(new MyOnClickListener(this));
        this.submit.setOnClickListener(this);
        //submit.s
        //submit.setO
        
        
        
        
        
        
        
        

        /*
        try {
    	    
        	
        	JSONArray jArrayReturn = JSONfunctions.getJSONfromURL(postsURL);
        	
        	
        	
        	JSONObject json_data = jArrayReturn.getJSONObject(entry);
	    	
	    	
	    	StringBuilder displayMe = new StringBuilder();
	    	
	    	Log.i("log_tag","thread: "+json_data.getInt("threadID")+
	    			", post: "+json_data.getString("postID")+
                    ", content: "+json_data.getString("postContent")+
                    ", user ID: "+json_data.getString("userID")+
                    ", username: "+json_data.getString("userName")
	    	);
	    	
	    	displayMe.append("\n\n\n\n\n");
	    	displayMe.append("thread: ");
	    	displayMe.append( json_data.getInt("threadID") );
	    	displayMe.append("\npost: ");
	    	displayMe.append( json_data.getInt("postID") );
	    	displayMe.append("\ncontent: ");
	    	displayMe.append( json_data.getString("postContent") );
	    	displayMe.append("\nuser ID: ");
	    	displayMe.append( json_data.getInt("userID") );
	    	displayMe.append("\nusername: ");
	    	displayMe.append( json_data.getString("userName") );
        	
	    	
	    	textView.setText( displayMe.toString() );
        	
    	    
        } catch (JSONException e) {
        	Log.e("log_tag", "Error parsing data "+e.toString());
        } catch (Exception e) {
        	Log.e("log_tag", "Error parsing data "+e.toString());
        }
        
        */
        
        
        
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
        
        
    }
    
    
    @Override
    public void registerObserver(AttemptController1 controller) {

        this.controller = controller;

    }



	@Override
	public void onClick(View viewEvent) {
		// TODO Auto-generated method stub

		
		//Object source = event.getSource();
		
		//returns int
		int source = viewEvent.getId();
		//int source = viewEvent.getComponent
		
		
		//getNextPost button
		if (source == R.id.button1)
		{
		    this.controller.processNextPostEvent();
		}
		
		//submit button was pressed
		else if (source == R.id.submit)
		{
			this.controller.processSubmitEvent();
		}
	}



	@Override
	public void updateTextView(String show) {
		// TODO Auto-generated method stub
		
		this.textView.setText( show );
		
	}



}
