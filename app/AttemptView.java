package com.MichaelFAbbott.myfirstapp;



//import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.view.View.OnClickListener;



public interface AttemptView extends OnClickListener {
	
	
	/**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     * 
     * @param controller
     *            controller to register
     */
    void registerObserver(AttemptController1 controller);
    
    
    //still need those update methods
    
    void updateTextView(String show);

}
