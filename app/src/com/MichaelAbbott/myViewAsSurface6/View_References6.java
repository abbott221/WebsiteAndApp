package com.MichaelAbbott.myViewAsSurface6;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Vibrator;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class View_References6 {
	
	
	
	private Spinner lolSpinner;
	private ArrayAdapter<CharSequence> lolAdapter;
	
	private Spinner occSpinner;
	private ArrayAdapter<CharSequence> occAdapter;
	
	
	private Button turnButton;
	
	
	private ProgressBar topBar;
	private ProgressBar bottomBar;
	
	
	private Board_Listener6 controller;
	
	
	
	public View_References6() {
		this.lolSpinner = null;
		this.lolAdapter = null;
		
		this.occSpinner = null;
		this.occAdapter = null;
		
		this.turnButton = null;
		
		this.topBar = null;
		this.bottomBar = null;
		
		this.controller = null;
	}
	
	//called nowhere yet
	public void registerObserver(Board_Listener6 newController)
	{
		controller = newController;
	}
	
	
    
	public Button getTurnButton()
	{
		return this.turnButton;
	}
    public void setTurnButton(Button newButton)
	{
		this.turnButton = newButton;
	}
	
	
    
    public Spinner getSpinner()
	{
		return this.lolSpinner;
	}
    public void setSpinner(Spinner newSpinner)
	{
		this.lolSpinner = newSpinner;
	}
    public void updateSpinner(int newPosition)
	{
		this.lolSpinner.setSelection(newPosition);
	}
    
    
    public ArrayAdapter<CharSequence> getAdapter()
	{
		return this.lolAdapter;
	}
    public void setAdapter(ArrayAdapter<CharSequence> newAdapter)
	{
		this.lolAdapter = newAdapter;
	}
    
    
    
    public Spinner getOccSpinner()
	{
		return this.occSpinner;
	}
    public void setOccSpinner(Spinner newSpinner)
	{
		this.occSpinner = newSpinner;
	}
    public void updateOccSpinner(int newPosition)
	{
		this.occSpinner.setSelection(newPosition);
	}
    
    
    
    public ArrayAdapter<CharSequence> getOccAdapter()
	{
		return this.occAdapter;
	}
    public void setOccAdapter(ArrayAdapter<CharSequence> newAdapter)
	{
		this.occAdapter = newAdapter;
	}
    
    
    
    public ProgressBar getTopBar()
	{
		return this.topBar;
	}
    public void setTopBar(ProgressBar newBar)
	{
		this.topBar = newBar;
	}
    public void updateTopBar(int num, int denom)
	{
		int progress = this.topBar.getMax() * num / denom;
    	this.topBar.setProgress(progress);
	}
    public void updateTopVisibility(int newValue)
	{
		if (newValue == 0) {
			this.topBar.setVisibility(View.GONE);
		} else if (newValue == 1) {
			this.topBar.setVisibility(View.INVISIBLE);
		} else if (newValue == 2) {
			this.topBar.setVisibility(View.VISIBLE);
		}
	}
    
    
    public ProgressBar getBottomBar()
	{
		return this.bottomBar;
	}
    public void setBottomBar(ProgressBar newBar)
	{
		this.bottomBar = newBar;
	}
    public void updateBottomBar(int num, int denom)
	{
		int progress = this.bottomBar.getMax() * num / denom;
    	this.bottomBar.setProgress(progress);
	}
    public void updateBottomVisibility(int newValue)
	{
		if (newValue == 0) {
			this.bottomBar.setVisibility(View.GONE);
		} else if (newValue == 1) {
			this.bottomBar.setVisibility(View.INVISIBLE);
		} else if (newValue == 2) {
			this.bottomBar.setVisibility(View.VISIBLE);
		}
	}
    
    public void updateBothVisibility(int newValue)
	{
		if (newValue == 0) {
			this.topBar.setVisibility(View.GONE);
			this.bottomBar.setVisibility(View.GONE);
		} else if (newValue == 1) {
			this.topBar.setVisibility(View.INVISIBLE);
			this.bottomBar.setVisibility(View.INVISIBLE);
		} else if (newValue == 2) {
			this.topBar.setVisibility(View.VISIBLE);
			this.bottomBar.setVisibility(View.VISIBLE);
		}
	}
    
    
	
}






