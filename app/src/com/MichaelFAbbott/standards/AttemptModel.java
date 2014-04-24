package com.MichaelFAbbott.standards;

import org.json.JSONArray;


public interface AttemptModel {
	
	//constructor constructs every field/private variable
	
	//then a bunch of getters/setters
	//setters might not be necessary for some reference types?
	
	
	public String getPostsURL();
	
	public String getThreadsURL();
	
	public String getTargetURL();
	
	public int getEntry();
	public void setEntry(int newValue);
	
	public JSONArray getArray();
	public void setArray(String result);
	
	//public /*static*/ JSONArray getJSONfromURL(String url);
	//public /*static*/ void postData(String url);
	
}
