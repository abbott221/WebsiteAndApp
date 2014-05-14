package com.MichaelAbbott.myViewAsSurface5;


import com.MichaelAbbott.myViewAsSurface5.Board_Model5;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.BlockState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.HeldState;
import com.MichaelAbbott.myViewAsSurface5.Hexagon5.OccupantState;


public class Board_Maps5 {
	
	
	public static void map1(Board_Model5 model) {
		
		int myRows = 8;
		int myColumns = 5;
		
		Hexagon5[][] board = new Hexagon5[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon5(i, j);
			}
		}
		
		model.setBoard(board, myRows, myColumns);
	}
	
	

	public static void map2(Board_Model5 model) {
		
		int myRows = 8;
		int myColumns = 8;
		
		Hexagon5[][] board = new Hexagon5[ myRows ][ myColumns ];
		
		for (int i = 0; i < myRows; i++)
		{
			for (int j = 0; j < myColumns; j++)
			{
				board[i][j] = new Hexagon5(i, j);
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
		
		board[1][1].setOccupantState(OccupantState.P_WHITE);
		
		model.setBoard(board, myRows, myColumns);
	}
	
	
}






