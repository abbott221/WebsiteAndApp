package com.MichaelFAbbott.standards;



//import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.view.View.OnClickListener;



public interface AttemptView extends OnClickListener {
	
	
	//a private variable enum of the current state?
	//constructor: creates all the widgets, does layouts, adds action listeners
	
	//a bunch of view updaters
	//finally, "actionPerformed()" which changes the state and calls controller's processEvent methods
	
	
	
	
	//right after constructor
	void registerObserver(AttemptController controller);
    
    
    //still need those update methods
    
    void updateTextView(String show);

}
