package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MyOnClickListener implements OnClickListener {

	MainActivity caller;
	
	public MyOnClickListener(MainActivity activity) {
		this.caller = activity;
	}
	
	public void onClick(View view) {
		
		

		//String url = "http://androidtesting.x10host.com/androidJSON.php";
		//String url = "http://google.com";
        //boolean diagnosis = false;
        
		
		if (view.getId() == R.id.button1)
		{
		    
		    
            try {
    	        
        	    //JSONObject jReturn = JSONfunctions.getJSONfromURL(url);
        	    
        	    //JSONArray names = jReturn.names();
        	    //JSONArray jArrayReturn = jReturn.toJSONArray(names);
        	    
        	    JSONArray jArrayReturn = JSONfunctions.getJSONfromURL(this.caller.postsURL);
    	        
        	    if ( (this.caller.entry + 2) == jArrayReturn.length() )
        	    {
        		    this.caller.entry = 1;
        	    }
        	    else
        	    {
        		    this.caller.entry += 1;
        	    }
        	    
        	    JSONObject json_data = jArrayReturn.getJSONObject(this.caller.entry);
	    	    
	    	    
	    	    StringBuilder displayMe = new StringBuilder();
	    	    /*
	    	    Log.i("log_tag","num: "+json_data.getInt("postNumber")+
	    			", user: "+json_data.getString("postUser")+
                    ", content: "+json_data.getString("postContent")
	    	    );
	    	    */
	    	    Log.i("log_tag","thread: "+json_data.getInt("threadID")+
	    			", post: "+json_data.getString("postID")+
                    ", content: "+json_data.getString("postContent")+
                    ", user ID: "+json_data.getString("userID")+
                    ", username: "+json_data.getString("userName")
	    	    );
	    	    
	    	    /*
	    	    displayMe.append("num: ");
	    	    displayMe.append( json_data.getInt("postNumber") );
	    	    displayMe.append("\nuser: ");
	    	    displayMe.append( json_data.getString("postUser") );
	    	    displayMe.append("\ncontent: ");
	    	    displayMe.append( json_data.getString("postContent") );
	    	    */
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
	    	    
	    	    
	    	    this.caller.textView.setText( displayMe.toString() );
	    	    
	    	    
	    	    
            } catch (JSONException e) {
        	    Log.e("log_tag", "lol4 Error parsing data "+e.toString());
        	    
        	    //this.caller.textView.setText( "error 1" );
        	    
            } catch (Exception e) {
        	    Log.e("log_tag", "toplel Error parsing data "+e.toString());
        	    
                //this.caller.textView.setText( "error 2" );
                
            }
		}
		else if (view.getId() == R.id.submit)
		{
		    try {
                
                // CALL GetText method to make post method call
                //GetText();
                
                
                JSONfunctions.postData(this.caller.targetURL);
                
            }
            catch(Exception ex)
            {
                this.caller.textView.setText( " url exeption! " );
            }
		}
		
		
	}
}
