package com.MichaelAbbott.GdxMainPackage;

import com.MichaelAbbott.GdxMainPackage.Hexagon.CubeState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Maps {
	
	
	public static void map1(Mediator med, Model_General model) {
		
		int myRows = 5;
		int myColumns = 8;
		
		/*
		if (med == null) {
			System.out.println("mediator");
		}
		if (med.model == null) {
			System.out.println("model");
		}
		/**/
		
		
		
		//model.setBoard(myRows, myColumns);
		
		Hexagon[][] board = new Hexagon[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon(med, i, j);
			}
		}
		
		
		model.setBoard(board);
		model.setRows(myRows);
		model.setColumns(myColumns);
	}
	
	
	
	
	public static void map2(Mediator med, Model_General model) {
		
		int myRows = 8;
		int myColumns = 9;
		
		
		
		Hexagon[][] board = new Hexagon[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon(med, i, j);
			}
		}
		
		
		board[7][0].setCubeState(CubeState.NONE);
		board[7][3].setCubeState(CubeState.NONE);
		board[7][4].setCubeState(CubeState.NONE);
		board[7][5].setCubeState(CubeState.NONE);
		board[7][8].setCubeState(CubeState.NONE);
		
		board[6][0].setCubeState(CubeState.NONE);
		board[6][2].setCubeState(CubeState.DIRT);
		board[6][3].setCubeState(CubeState.DIRT);
		board[6][7].setCubeState(CubeState.NONE);
		
		board[5][0].setCubeState(CubeState.NONE);
		board[5][2].setCubeState(CubeState.DIRT);
		board[5][3].setCubeState(CubeState.NONE);
		board[5][5].setCubeState(CubeState.NONE);
		board[5][7].setCubeState(CubeState.DIRT);
		board[5][8].setCubeState(CubeState.NONE);
		
		board[4][0].setCubeState(CubeState.NONE);
		board[4][2].setCubeState(CubeState.NONE);
		board[4][3].setCubeState(CubeState.NONE);
		board[4][5].setCubeState(CubeState.NONE);
		board[4][6].setCubeState(CubeState.NONE);
		board[4][8].setCubeState(CubeState.DIRT);
		
		board[3][2].setCubeState(CubeState.NONE);
		board[3][5].setCubeState(CubeState.NONE);
		board[3][6].setCubeState(CubeState.NONE);
		board[3][8].setCubeState(CubeState.NONE);
		
		board[3][4].setCubeState(CubeState.DIRT);
		
		board[2][0].setCubeState(CubeState.NONE);
		board[2][2].setCubeState(CubeState.NONE);
		board[2][3].setCubeState(CubeState.NONE);
		board[2][5].setCubeState(CubeState.DIRT);
		board[2][6].setCubeState(CubeState.NONE);
		
		board[1][4].setCubeState(CubeState.DIRT);
		board[1][7].setCubeState(CubeState.DIRT);
		board[1][8].setCubeState(CubeState.NONE);
		
		board[0][0].setCubeState(CubeState.NONE);
		board[0][3].setCubeState(CubeState.NONE);
		board[0][6].setCubeState(CubeState.NONE);
		board[0][7].setCubeState(CubeState.DIRT);
		board[0][8].setCubeState(CubeState.NONE);
		
		
		model.setBoard(board);
		model.setRows(myRows);
		model.setColumns(myColumns);
		
		
		
		
		Actor[][] occupantArray = new Actor[myRows][myColumns];
		//model.setOccupantArray(occupantArray);
		
		occupantArray[6][4] = new Actor_BeigeAlien( med, board[6][4] );
		
		occupantArray[6][5] = new Actor_BeigeAlien( med, board[6][5] );
		
		occupantArray[6][2] = new Actor_WhitePortal( med, board[6][2] );
		
		model.setOccupantArray(occupantArray);
		
		
		
	}
	
	
	
	
	
}


