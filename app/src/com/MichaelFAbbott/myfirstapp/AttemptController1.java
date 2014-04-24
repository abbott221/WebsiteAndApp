package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.standards.AttemptController;
import com.MichaelFAbbott.standards.AttemptModel;
import com.MichaelFAbbott.standards.AttemptView;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class AttemptController1 implements AttemptController, OnClickListener {

	//MainActivity callerView;
	
	
	
	//private final AttemptModel model;
    //private final AttemptView view;
    
    AttemptModel model;
    AttemptView view;
	
	
	
	
	public AttemptController1(AttemptModel aModel, AttemptView aView) {
		//this.callerView = activity;
		
		this.model = aModel;
		this.view = aView;
	}
	
	public void onClick(View view) {
		
		
        
		
		if (view.getId() == R.id.getNextPost1)
		{
		    
		    
            try {
    	        
        	    
        	    JSONArray jArrayReturn = AttemptModel1.getJSONfromURL( this.model.getPostsURL() );
    	        
        	    if ( (this.model.getEntry() + 2) == jArrayReturn.length() )
        	    {
        		    //this.callerView.entry = 1;
        	    	this.model.setEntry(1);
        	    }
        	    else
        	    {
        		    //this.callerView.entry += 1;
        		    
        		    int temp = this.model.getEntry();
        		    temp += 1;
        		    this.model.setEntry(temp);
        	    }
        	    
        	    JSONObject json_data = jArrayReturn.getJSONObject( this.model.getEntry() );
	    	    
	    	    
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
	    	    
	    	    
	    	    //this.view.textView.setText( displayMe.toString() );
	    	    this.view.updateTextView( displayMe.toString() );
	    	    
	    	    
	    	    
            } catch (JSONException e) {
        	    Log.e("log_tag", "Error parsing data "+e.toString());
        	    
        	    
            } catch (Exception e) {
        	    Log.e("log_tag", "Error parsing data "+e.toString());
        	    
                
            }
		}
		else if (view.getId() == R.id.submit1)
		{
		    try {
                
                AttemptModel1.postData( this.model.getTargetURL() );
                
            }
            catch(Exception ex)
            {
                //this.view.textView.setText( " url exeption! " );
            	this.view.updateTextView( " url exeption! " );
            	
            }
		}
		
		
	}

	
	
	
	
	
	
	
	@Override
	public void processNextPostEvent() {
		try {
	        
    	    
    	    JSONArray jArrayReturn = AttemptModel1.getJSONfromURL( this.model.getPostsURL() );
	        
    	    if ( (this.model.getEntry() + 2) == jArrayReturn.length() )
    	    {
    		    //this.callerView.entry = 1;
    		    this.model.setEntry(1);
    	    }
    	    else
    	    {
    		    //this.callerView.entry += 1;
    		    
    		    int temp = this.model.getEntry();
    		    temp += 1;
    		    this.model.setEntry(temp);
    	    }
    	    
    	    JSONObject json_data = jArrayReturn.getJSONObject(this.model.getEntry());
    	    
    	    
    	    StringBuilder displayMe = new StringBuilder();
    	    
    	    Log.i("log_tag","thread: "+json_data.getInt("threadID")+
    			", post: "+json_data.getString("postID")+
                ", content: "+json_data.getString("postContent")+
                ", user ID: "+json_data.getString("userID")+
                ", username: "+json_data.getString("userName")
    	    );
    	    
    	    //displayMe.append("\n\n\n\n\n");
    	    displayMe.append("\n\n");
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
    	    
    	    
    	    //this.callerView.textView.setText( displayMe.toString() );
    	    this.view.updateTextView( displayMe.toString() );
    	    
    	    
    	    
        } catch (JSONException e) {
    	    Log.e("log_tag", "Error parsing data "+e.toString());
    	    
    	    
        } catch (Exception e) {
    	    Log.e("log_tag", "Error parsing data "+e.toString());
    	    
            
        }
		
	}

	@Override
	public void processSubmitEvent() {
		try {
            
            AttemptModel1.postData( this.model.getTargetURL() );
            
        }
        catch(Exception ex)
        {
            //this.callerView.textView.setText( " url exeption! " );
            this.view.updateTextView( " url exeption! " );
        }
		
	}

	
	
	@Override
	public void updateViewToMatchModel() {
		// TODO Auto-generated method stub
		
	}
}
