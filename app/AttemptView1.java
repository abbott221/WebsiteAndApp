package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	
	
	//NEW CONTENT BEGINS
	
	//TextView content;
    //EditText fname, email, login, pass;
    //String Name, Email, Login, Pass;
    
    EditText threadID, postContent, userID, userName;
    Button submit;
    
    //NEW CONTENT ENDS
	
	
	
	Button button;
	TextView textView;
	//boolean changedText = false;
	int entry = 1;
	
	
	String postsURL = "http://androidtesting.x10host.com/JSONposts.php";
	String threadsURL = "http://androidtesting.x10host.com/JSONthreads.php";
	
	//similar to PostsForm.php
	String targetURL = "http://androidtesting.x10host.com/JSONtarget.php";
	
	
	

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
        
        
        //NEW CONTENT BEGINS
        
        
        //threadID
        //postContent
        //userID
        //userName
        
        //content    =   (TextView)findViewById( R.id.content );
        //fname      =   (EditText)findViewById(R.id.name);
        //email      =   (EditText)findViewById(R.id.email);
        //login      =    (EditText)findViewById(R.id.loginname);
        //pass       =   (EditText)findViewById(R.id.password);
         
         
        //Button saveme=(Button)findViewById(R.id.save);
        
        
        threadID     =   (EditText)findViewById( R.id.threadID );
        postContent  =   (EditText)findViewById(R.id.postContent);
        userID       =   (EditText)findViewById(R.id.userID);
        userName     =   (EditText)findViewById(R.id.userName);
        
        submit       =   (Button)findViewById(R.id.submit);
         
         

        
        submit.setOnClickListener(new MyOnClickListener(this));
        
        /*
        saveme.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v)
            {
                try{
                     
                         // CALL GetText method to make post method call
                        //GetText();
                        
                        
                        JSONfunctions.postData();
                        
                 }
                catch(Exception ex)
                 {
                    content.setText(" url exeption! " );
                 }
            }
        });
        */
        
        //NEW CONTENT ENDS
        
        
        
        
        
        button = (Button) findViewById(R.id.button1);
        
        //The MyOnClickListener Class is also new content JSYK
        button.setOnClickListener(new MyOnClickListener(this));
        
        textView = (TextView) findViewById(R.id.textView1);
        
        
        
        
        /*
         * JSON OBJECT STUFF GOES HERE
         */
        
        
        //use global postsURL
        //String url = "http://androidtesting.x10host.com/JSONposts.php";
        //String url = "http://google.com";
        
        

        try {
    	    
        	//JSONObject jReturn = JSONfunctions.getJSONfromURL(url);
        	
        	//JSONArray names = jReturn.names();
        	//JSONArray jArrayReturn = jReturn.toJSONArray(names);
        	
        	JSONArray jArrayReturn = JSONfunctions.getJSONfromURL(postsURL);
        	
        	
        	
        	
        	
    	    
        	/*
        	for ( int i = 0; i < (jArrayReturn.length() - 5); i++ ) {
    	    	JSONObject json_data = jArrayReturn.getJSONObject(i);
    	    	
    	    	
    	    	StringBuilder displayMe = new StringBuilder();
    	    	//json_data.
    	    	
    	    	Log.i("log_tag","num: "+json_data.getInt("postNumber")+
    	    			", user: "+json_data.getString("postUser")+
                        ", content: "+json_data.getString("postContent")
    	    	);
    	    	
    	    	displayMe.append("num: ");
    	    	displayMe.append( json_data.getInt("postNumber") );
    	    	displayMe.append("\nuser: ");
    	    	displayMe.append( json_data.getString("postUser") );
    	    	displayMe.append("\ncontent: ");
    	    	displayMe.append( json_data.getString("postContent") );
    	    	
    	    	textView.setText(displayMe.toString());
    	    } //END FOR LOOP
        	*/
        	
        	
        	JSONObject json_data = jArrayReturn.getJSONObject(entry);
	    	
	    	
	    	StringBuilder displayMe = new StringBuilder();
	    	//json_data.
	    	
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
        	Log.e("log_tag", "lol4 Error parsing data "+e.toString());
        } catch (Exception e) {
        	Log.e("log_tag", "toplel Error parsing data "+e.toString());
        }
        
        
        
        
        
        //textView.setText("Hello World!");
        
        
        
    }



}
