package com.MichaelFAbbott.myfirstapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public interface AttemptController {
	
	void processNextPostEvent();
	
	void processSubmitEvent();
	
}
