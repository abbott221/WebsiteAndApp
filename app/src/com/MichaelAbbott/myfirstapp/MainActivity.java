package com.MichaelAbbott.myfirstapp;


import com.MichaelAbbott.standards.AttemptModel;
import com.MichaelAbbott.standards.AttemptView;
import com.MichaelAbbott.hexagonalgame.R;
import com.MichaelAbbott.myViewPlayerMode.Player_MyActivityPlayer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;




public class MainActivity extends Activity {
	
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
        
      
        AttemptModel1 model = new AttemptModel1();
        
        
        
        //AttemptView1.getNextPost = (Button) findViewById(R.id.getNextPost1);
        
        //System.out.println("before intent");
        
        //original position
        //Intent i = new Intent(getBaseContext(), AttemptView1.class);
        //startActivity(i);
        
        AttemptView view = new AttemptView1();
        
        
        
        //System.out.println("after view");
        
        
        AttemptController1 controller = new AttemptController1(model, view);
        
        
        

        view.registerObserver(controller);
        
        
        
        
        
        //Intent i = new Intent(getBaseContext(), AttemptView1.class);
        
        /*
        Intent i = new Intent(getBaseContext(), Post_View.class);
        startActivity(i);
        /**/
        
        Intent i = new Intent(getBaseContext(), Player_MyActivityPlayer.class);
        startActivity(i);
        
        
        //System.out.println("controller registered");
        
        
    }



}
