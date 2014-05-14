/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

package com.MichaelAbbott.myViewAsSurface6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.MichaelAbbott.myViewAsSurface6.Hexagon6.OccupantState;
import com.MichaelFAbbott.myfirstapp.R;


/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as it
 * moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Actor_BeigeAlien extends Actor {
    
	
	
	//private Bitmap occBeige;
	
	//private int drawScale;
    //private int drawX;
    //private int drawY;
	
	
    public Actor_BeigeAlien(Board_Model6 grid, Hexagon6 loc) {
        
    	
    	//this.setColor(Color.RED);
        
    	//context = this.getGrid().g
    	
    	
        
        Resources res = grid.getContext().getResources();
        Bitmap occBeige = BitmapFactory.decodeResource(res, R.drawable.alien_beige);
        //occBeige = BitmapFactory.decodeResource(res, R.drawable.alien_beige);
        
        
        this.setAppearance(occBeige);
        
        float top = occBeige.getHeight() / 2;
        float left = occBeige.getWidth() / 2;
        
        //top += 60;
        
        this.setDrawScale(1.0f);
        this.setDrawX(-1 * left);
        this.setDrawY(-1 * top);
        
        this.setTranslateY(-60);
        this.setTranslateX(0);
        
        this.setActorType(ActorType.ALIEN);
        
        this.setGrid(grid);
        this.setLocation(loc);
    }
    
    
    
    
    
}

