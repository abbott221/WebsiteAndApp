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
import org.json.JSONObject;

import android.util.Log;
public class JSONfunctions {
	
	MainActivity caller;
	
    public static JSONArray getJSONfromURL(String url) {
    	
    	String result = "";
    	
	    InputStream is = null;
	    //JSONObject jArray = null;
	    JSONArray jArray = null;

	    
	    
	    // Download JSON data from URL
	    //http post
	    try {
	        //System.out.println("MRA 1");
	    	HttpClient httpclient = new DefaultHttpClient();
	    	//System.out.println("MRA 2");
	    	HttpPost httppost = new HttpPost(url);
	    	//System.out.println("MRA 3");
	        
	        //this fucker is the problem.
	        HttpResponse response = httpclient.execute(httppost);
	        
	        //System.out.println("MRA 4");
	        
	        //GET ENTITY
	        HttpEntity entity = response.getEntity();
	        
	        //System.out.println("MRA 5");
	        
	        is = entity.getContent();

	    } catch (Exception e) {
	        Log.e("log_tag", "lol1 Error in http connection " + e.toString());
	    }

	    
	    
	    
	    
	    
	    // Convert response to string
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
	        Log.e("log_tag", "lol2 Error converting result " + e.toString());
	    }

	    try {

	        //jArray = new JSONObject(result);
	        jArray = new JSONArray(result);
	        
	        
	    } catch (JSONException e) {
	        
	    	
	    	
	    	//PROBLEM IS HERE
	    	
	    	Log.e("log_tag", "lol3 Error parsing data " + e.toString());
	        
	    } catch (Exception e) {
	        Log.e("log_tag", "toplel Error parsing data " + e.toString());
	    }

	    return jArray;
	    
    }
    
    
    public static void postData(String url) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        //HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");
        HttpPost httppost = new HttpPost(url);

        try {
            // Add your data
        	
        	
        	
            //List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
        	
            //nameValuePairs.add(new BasicNameValuePair("id", "12345"));
            //nameValuePairs.add(new BasicNameValuePair("stringdata", "Hi"));
        	
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
        
        
        
        
        //at end, add some means of adjusting the View
        
        //content.setText( text  );
        
    }
	
}




