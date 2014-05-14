package com.MichaelAbbott.myViewAsSurface5;

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

import com.MichaelAbbott.myViewAsSurface5.Hexagon5.BlockState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.OccupantState;

import android.util.Log;



public class AI_Hexagon5 {
	
	
	
	public static boolean occupantIsPortal(Hexagon5 test) {
		
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
		
		return isAPortal;
	}
	
	

	public static boolean occupantIsCreature(Hexagon5 test) {
		
		boolean isACreature = false;
		
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
		
		return isACreature;
	}
	
	
	
	
	
	
	
	public static Hexagon5 getTopLeft(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	public static Hexagon5 getTopRight(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	public static Hexagon5 getLeft(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	public static Hexagon5 getRight(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	public static Hexagon5 getBottomLeft(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	public static Hexagon5 getBottomRight(Hexagon5 test, Board_Model5 model) {
		Hexagon5 result = null;
		
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
	
	
	
	

	public static ArrayList<Hexagon5> getNeighbors(Hexagon5 test, Board_Model5 model) {
		
		ArrayList<Hexagon5> result = new ArrayList<Hexagon5>();
		
		
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
	
	
	
	
	
	
	
	
	public static ArrayList<Hexagon5> getBlockNeighbors(Hexagon5 test, Board_Model5 model) {
		
		ArrayList<Hexagon5> result = getNeighbors(test, model);
		
		Hexagon5 temp;
		
		
		
		
		for (int i = result.size() - 1; i >= 0; i--) {
			temp = result.get(i);
			
			if (temp.getBlockState() == BlockState.NONE) {
				result.remove(temp);
			}
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
}



