package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	public chessPiece[][] getPiecess() {
		chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumn()];
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumn(); j++) {
				mat[i][j] = (chessPiece) board.piece(i, j); 
			}
		}
		
		return mat;
	}
	
	
}
