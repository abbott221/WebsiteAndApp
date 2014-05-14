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

import com.MichaelAbbott.myViewAsSurface6.Actor.ActorType;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.OccupantState;
import com.MichaelFAbbott.myfirstapp.R;


/**
 * A <code>Bug</code> is an actor that can move and turn. It drops flowers as it
 * moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class Actor_WhitePortal extends Actor {
    
	
	
	//private Bitmap occBeige;
	
	//private int drawScale;
    //private int drawX;
    //private int drawY;
	
	
    public Actor_WhitePortal(Board_Model6 grid, Hexagon6 loc) {
        
        Resources res = grid.getContext().getResources();
        Bitmap occBeige = BitmapFactory.decodeResource(res, R.drawable.portal_white);
        //occBeige = BitmapFactory.decodeResource(res, R.drawable.alien_beige);
        
        
        this.setAppearance(occBeige);
        
        float top = occBeige.getHeight() / 2;
        float left = occBeige.getWidth() / 2;
        
        //top += 45;
        
        this.setDrawScale(2.0f);
        this.setDrawX(-1 * left);
        this.setDrawY(-1 * top);
        
        this.setTranslateY(-90);
        this.setTranslateX(0);
        
        this.setActorType(ActorType.PORTAL);
        
        this.setGrid(grid);
        this.setLocation(loc);
        
        
        
        this.setMaxHealth(8);
        this.setCurrentHealth(8);
        
        this.setMaxEnergy(8);
        this.setCurrentEnergy(8);
        
        this.setRange(0);
        this.setPower(0);
    }
    
    
    
    
    
}


