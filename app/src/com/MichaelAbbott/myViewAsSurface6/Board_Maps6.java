package com.MichaelAbbott.myViewAsSurface6;


import java.util.ArrayList;

import com.MichaelAbbott.myViewAsSurface6.Board_Model6;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.BlockState;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.HeldState;
import com.MichaelAbbott.myViewAsSurface6.Hexagon6.OccupantState;


public class Board_Maps6 {
	
	
	public static void map1(Board_Model6 model) {
		
		int myRows = 8;
		int myColumns = 5;
		
		Hexagon6[][] board = new Hexagon6[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon6(i, j, model);
			}
		}
		
		model.setBoard(board, myRows, myColumns);
	}
	
	

	public static void map2(Board_Model6 model) {
		
		int myRows = 8;
		int myColumns = 8;
		
		Hexagon6[][] board = new Hexagon6[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon6(i, j, model);
			}
		}
		
		board[0][0].setBlockState(BlockState.NONE);
		board[0][3].setBlockState(BlockState.NONE);
		board[0][4].setBlockState(BlockState.NONE);
		board[0][5].setBlockState(BlockState.NONE);
		
		board[1][1].setBlockState(BlockState.DIRT);
		board[1][2].setBlockState(BlockState.DIRT);
		board[1][6].setBlockState(BlockState.NONE);
		
		board[2][0].setBlockState(BlockState.NONE);
		board[2][2].setBlockState(BlockState.DIRT);
		board[2][3].setBlockState(BlockState.NONE);
		board[2][5].setBlockState(BlockState.NONE);
		board[2][7].setBlockState(BlockState.DIRT);
		
		board[3][1].setBlockState(BlockState.NONE);
		board[3][2].setBlockState(BlockState.NONE);
		board[3][4].setBlockState(BlockState.NONE);
		board[3][5].setBlockState(BlockState.NONE);
		board[3][7].setBlockState(BlockState.DIRT);
		
		board[4][2].setBlockState(BlockState.NONE);
		board[4][5].setBlockState(BlockState.NONE);
		board[4][6].setBlockState(BlockState.NONE);
		
		board[4][4].setBlockState(BlockState.DIRT);
		//board[5][4].setBlockState(BlockState.DIRT);
		//board[6][4].setBlockState(BlockState.DIRT);
		
		board[5][1].setBlockState(BlockState.NONE);
		board[5][2].setBlockState(BlockState.NONE);
		board[5][4].setBlockState(BlockState.DIRT);
		board[5][5].setBlockState(BlockState.NONE);
		
		board[6][4].setBlockState(BlockState.DIRT);
		board[6][7].setBlockState(BlockState.DIRT);
		
		board[7][2].setBlockState(BlockState.NONE);
		board[7][5].setBlockState(BlockState.NONE);
		board[7][6].setBlockState(BlockState.DIRT);
		board[7][7].setBlockState(BlockState.NONE);
		
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j].setHeldState(HeldState.NONE);
			}
		}
		
		//board[1][5].setOccupantState(OccupantState.P_WHITE);
		
		model.setBoard(board, myRows, myColumns);
		
		
		
		
		//IMPLEMENTATION 2
		
		Actor[][] occupantArray = new Actor[myRows][myColumns];
		
		/*
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon6(i, j, model);
			}
		}
		/**/
		model.setOccupantArray(occupantArray);
		
		//something with players
		Actor newOccupant;
		
		
		ArrayList<Player> lolPlayers = new ArrayList<Player>();
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		lolPlayers.add(player1);
		lolPlayers.add(player2);
		
		model.setPlayers(lolPlayers);
		
		//model.setPlayers(2);
		
		model.setCurrentPlayer(player1);
		
		//occupantArray[1][1] = new Actor_WhitePortal( model, model.getHexagon(1, 1) );
		//model.setOccupant(1, 1, occupantArray[1][1]);
		
		
		
		
		model.setCurrentPlayer(player2);
		
		
		Actor newOccupant1 = new Actor_BeigeAlien( model, model.getHexagon(6, 4) );
		model.setOccupant(6, 4, newOccupant1);
		Actor newOccupant2 = new Actor_BeigeAlien( model, model.getHexagon(6, 5) );
		model.setOccupant(6, 5, newOccupant2);
		
		//last working
		//occupantArray[6][4] = new Actor_BeigeAlien( model, model.getHexagon(6, 4) );
		
		//model.setOccupant(6, 4, occupantArray[6][4]);
		//occupantArray[6][5] = new Actor_BeigeAlien( model, model.getHexagon(6, 5) );
		//model.setOccupant(6, 4, occupantArray[6][4]);
		
		
		
		
		model.setCurrentPlayer(player1);
		
		Actor newOccupant3 = new Actor_WhitePortal( model, model.getHexagon(1, 1) );
		model.setOccupant(1, 1, newOccupant3);
		
		//occupantArray[1][1] = new Actor_WhitePortal( model, model.getHexagon(1, 1) );
		
		//is this necessary? isn't the reference the same still?
		model.setOccupantArray(occupantArray);
	}
	
	
}






