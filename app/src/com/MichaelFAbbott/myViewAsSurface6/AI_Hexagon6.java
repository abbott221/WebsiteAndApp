package com.MichaelFAbbott.myViewAsSurface6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.MichaelFAbbott.myViewAsSurface6.Actor.ActorType;
import com.MichaelFAbbott.myViewAsSurface6.Hexagon6.BlockState;
import com.MichaelFAbbott.myViewAsSurface6.Hexagon6.OccupantState;

import android.util.Log;



public class AI_Hexagon6 {
	
	
	
	public static boolean occupantIsPortal(Hexagon6 test) {
		
		boolean isAPortal = false;
		
		if (test.getOccupantState() == OccupantState.P_BLUE) {
			isAPortal = true;
		} else if (test.getOccupantState() == OccupantState.P_GREEN) {
			isAPortal = true;
		} else if (test.getOccupantState() == OccupantState.P_RED) {
			isAPortal = true;
		} else if (test.getOccupantState() == OccupantState.P_WHITE) {
			isAPortal = true;
		} else if (test.getOccupantState() == OccupantState.P_YELLOW) {
			isAPortal = true;
		}
		
		
		//IMPLEMENTATION 2
		
		Actor occupant = test.getGrid().getOccupant( test.getRow(), test.getColumn() );
		
		if ( occupant.getActorType() == ActorType.PORTAL )
		{
			isAPortal = true;
		}
		
		//IMPLEMENTATION 2 END
		
		
		return isAPortal;
	}
	
	

	public static boolean occupantIsCreature(Hexagon6 test) {
		
		boolean isACreature = false;
		
		/*
		if (test.getOccupantState() == OccupantState.OCC_BEIGE) {
			isACreature = true;
		} else if (test.getOccupantState() == OccupantState.OCC_BLUE) {
			isACreature = true;
		} else if (test.getOccupantState() == OccupantState.OCC_GREEN) {
			isACreature = true;
		} else if (test.getOccupantState() == OccupantState.OCC_PINK) {
			isACreature = true;
		} else if (test.getOccupantState() == OccupantState.OCC_YELLOW) {
			isACreature = true;
		}
		/**/
		
		//IMPLEMENTATION 2
		
		Actor occupant = test.getGrid().getOccupant( test.getRow(), test.getColumn() );
		
		if ( occupant.getActorType() == ActorType.ALIEN )
		{
			isACreature = true;
		}
		
		//IMPLEMENTATION 2 END
		
		
		return isACreature;
	}
	
	
	
	
	
	
	
	public static Hexagon6 getTopLeft(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		//int maxR = model.getRows() - 1;
		//int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myRow != 0 ) {
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					result = model.getHexagon(myRow - 1, myColumn - 1);
				}
				
			}
			//ODD
			else {
				result = model.getHexagon(myRow - 1, myColumn);
			}
		}
		
		
		return result;
	}
	
	public static Hexagon6 getTopRight(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myRow != 0 ) {
			//EVEN
			if (myRow % 2 == 0) {
				result = model.getHexagon(myRow - 1, myColumn);
			}
			//ODD
			else {
				//result = model.getHexagon(myRow - 1, myColumn);
				
				if ( myColumn != maxC ) {
					result = model.getHexagon(myRow - 1, myColumn + 1);
				}
				
				
			}
		}
		
		
		return result;
	}
	
	public static Hexagon6 getLeft(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		//int maxR = model.getRows() - 1;
		//int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myColumn != 0 ) {
			result = model.getHexagon(myRow, myColumn - 1);
		}
		
		
		return result;
	}
	
	public static Hexagon6 getRight(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myColumn != maxC ) {
			result = model.getHexagon(myRow, myColumn + 1);
		}
		
		
		return result;
	}
	
	public static Hexagon6 getBottomLeft(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myRow != maxR ) {
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					result = model.getHexagon(myRow + 1, myColumn - 1);
				}
				
			}
			//ODD
			else {
				result = model.getHexagon(myRow + 1, myColumn);
			}
		}
		
		
		return result;
	}
	
	public static Hexagon6 getBottomRight(Hexagon6 test, Board_Model6 model) {
		Hexagon6 result = null;
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		if ( myRow != maxR ) {
			//EVEN
			if (myRow % 2 == 0) {
				result = model.getHexagon(myRow + 1, myColumn);
			}
			//ODD
			else {
				
				if ( myColumn != maxC ) {
					result = model.getHexagon(myRow + 1, myColumn + 1);
				}
				
			}
		}
		
		
		return result;
	}
	
	
	
	

	public static ArrayList<Hexagon6> getNeighbors(Hexagon6 test, Board_Model6 model) {
		
		ArrayList<Hexagon6> result = new ArrayList<Hexagon6>();
		
		
		int myRow = test.getRow();
		int myColumn = test.getColumn();
		
		int maxR = model.getRows() - 1;
		int maxC = model.getColumns() - 1;
		
		//****************************************
		
		
		if ( myRow != 0 ) {
			
			//TopRight or TopLeft
			result.add( model.getHexagon(myRow - 1, myColumn) );
			
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					//TopLeft
					result.add( model.getHexagon(myRow - 1, myColumn - 1) );
				}
				
			}
			//ODD
			else {
				
				if ( myColumn != maxC ) {
					//TopRight
					result.add( model.getHexagon(myRow - 1, myColumn + 1) );
				}
				
			}
		}
		
		
		
		if ( myRow != maxR ) {
			
			//BottomRight or BottomLeft
			result.add( model.getHexagon(myRow + 1, myColumn) );
			
			//EVEN
			if (myRow % 2 == 0) {
				
				if ( myColumn != 0 ) {
					//BottomLeft
					result.add( model.getHexagon(myRow + 1, myColumn - 1) );
				}
				
			}
			//ODD
			else {
				
				if ( myColumn != maxC ) {
					//BottomRight
					result.add( model.getHexagon(myRow + 1, myColumn + 1) );
				}
			}
		}
		
		
		
		if ( myColumn != 0 ) {
			//Left
			result.add( model.getHexagon(myRow, myColumn - 1) );
		}
		if ( myColumn != maxC ) {
			//Right
			result.add( model.getHexagon(myRow, myColumn + 1) );
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	public static ArrayList<Hexagon6> getBlockNeighbors(Hexagon6 test, Board_Model6 model) {
		
		ArrayList<Hexagon6> result = getNeighbors(test, model);
		
		Hexagon6 temp;
		
		
		
		
		for (int i = result.size() - 1; i >= 0; i--) {
			temp = result.get(i);
			
			if (temp.getBlockState() == BlockState.NONE) {
				result.remove(temp);
			}
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
}



