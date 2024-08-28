package boardgame;

public class Board {
	private int column;
	private int rows;
	private Piece [][] piece;
	public Board(int column, int rows) {
		this.column = column;
		this.rows = rows;
		piece = new Piece[rows][column];
	}
	
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public Piece piece (int row, int column) {
		return piece[row][column];
	}
	
	public Piece piece(Position position) {
		return piece[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		this.piece [position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

}
