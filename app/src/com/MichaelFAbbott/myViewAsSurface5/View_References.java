package com.MichaelFAbbott.myViewAsSurface5;

import com.MichaelFAbbott.customView.GameMap;
import com.MichaelFAbbott.customView.Tile;

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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class View_References {
	
	
	
	private Spinner lolSpinner;
	private ArrayAdapter<CharSequence> lolAdapter;
	
	private Spinner occSpinner;
	private ArrayAdapter<CharSequence> occAdapter;
	
	
	
	
	private Board_Listener5 controller;
	
	
	
	public View_References() {
		this.lolSpinner = null;
		this.lolAdapter = null;
		
		this.occSpinner = null;
		this.occAdapter = null;
		
		this.controller = null;
	}
	
	//called nowhere yet
	public void registerObserver(Board_Listener5 newController)
	{
		controller = newController;
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
    
    
    
    
    
    
	
}






