package com.MichaelFAbbott.myfirstapp;


import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;




public class AttemptMain extends Activity {
	
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
        
        
        
        //NNCalcModel model = new NNCalcModel1();
        //NNCalcView view = new NNCalcView1();
        //NNCalcController controller = new NNCalcController1(model, view);

        //view.registerObserver(controller);
        
      
        AttemptModel model = new AttemptModel();
        AttemptView1 view = new AttemptView1();
        AttemptController1 controller = new AttemptController1(model, view);

        view.registerObserver(controller);
        
        
    }



}
