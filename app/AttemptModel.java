package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;


public interface AttemptModel {
	
	public String getPostsURL();
	
	public String getThreadsURL();
	
	public String getTargetURL();
	
	public int getEntry();
	public void setEntry(int newValue);
	
	public JSONArray getArray();
	public void setArray(String result);
	
	public /*static*/ JSONArray getJSONfromURL(String url);
	public /*static*/ void postData(String url);
	
}
