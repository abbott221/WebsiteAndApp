package com.MichaelFAbbott.myfirstapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;


//this class can be "final"
//public final class AttemptModel
public class AttemptModel1 {
	/**
     * Model variables.
     */
    private final String postsURL, threadsURL, targetURL;
    
    private int entry;
    
    JSONArray postArray = null;

    /**
     * Default constructor.
     */
    public AttemptModel1() {
        this.postsURL = "http://androidtesting.x10host.com/JSONposts.php";
        this.threadsURL = "http://androidtesting.x10host.com/JSONthreads.php";
        
        this.targetURL = "http://androidtesting.x10host.com/JSONtarget.php";
        
        this.entry = 1;
        
        this.postArray = new JSONArray();
    }
    
    public String getPostsURL() {

        // TODO: fill in body

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return this.postsURL;
    }
    
    public String getThreadsURL() {

        // TODO: fill in body

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return this.threadsURL;
    }
    
    public String getTargetURL() {

        // TODO: fill in body

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return this.targetURL;
    }
    
    
    public int getEntry()
    {
    	return this.entry;
    }
    
    public void setEntry(int newValue)
    {
    	this.entry = newValue;
    }
    
    
    
    
    public JSONArray getArray() {

        // TODO: fill in body

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return this.postArray;
    }
    
    //shouldn't need to be used? NNCalculator didn't have any setter methods
    public void setArray(String result) {

        // TODO: fill in body

        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
    	
    	try {
    		
			this.postArray = new JSONArray(result);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    
    
    public static JSONArray getJSONfromURL(String url) {
    	
    	String result = "";
    	
	    InputStream is = null;
	    JSONArray jArray = null;

	    
	    
	    // Download JSON data from URL
	    //http post
	    try {
	        HttpClient httpclient = new DefaultHttpClient();
	    	HttpPost httppost = new HttpPost(url);
	        
	        HttpResponse response = httpclient.execute(httppost);
	        
	        HttpEntity entity = response.getEntity();
	        
	        
	        is = entity.getContent();

	    } catch (Exception e) {
	        Log.e("log_tag", "Error in http connection " + e.toString());
	    }

	    
	    
	    
	    
	    
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
	        StringBuilder sb = new StringBuilder();
	        
	        
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	        is.close();
	        
	        result = sb.toString();
	        
	    } catch (Exception e) {
	        Log.e("log_tag", "Error converting result " + e.toString());
	    }

	    try {

	        jArray = new JSONArray(result);
	        
	        
	    } catch (JSONException e) {
	    	Log.e("log_tag", "Error parsing data " + e.toString());
	    } catch (Exception e) {
	        Log.e("log_tag", "Error parsing data " + e.toString());
	    }

	    return jArray;
    }
    
    
    public static void postData(String url) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            // Add your data
        	
        	
            //List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
        	
        	
        	//String pThreadID = caller.threadID.getText().toString();
        	
        	nameValuePairs.add(new BasicNameValuePair("pThreadID", "9"));
        	nameValuePairs.add(new BasicNameValuePair("pPostContent", "Hi"));
        	nameValuePairs.add(new BasicNameValuePair("pUserID", "9"));
        	nameValuePairs.add(new BasicNameValuePair("pUserName", "Hi"));
        	
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            
            
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        
    }
    
	
}




