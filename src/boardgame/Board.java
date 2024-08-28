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
	
	

}
