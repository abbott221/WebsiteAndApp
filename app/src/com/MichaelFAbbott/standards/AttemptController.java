package com.MichaelFAbbott.standards;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public interface AttemptController {
	
	void updateViewToMatchModel();
	
	//insert constructor here
	
	//should consist of a bunch of processing events
	
	void processNextPostEvent();
	
	void processSubmitEvent();
	
}
