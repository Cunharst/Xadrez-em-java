package boardgame;

public class Board {
	private int column;
	private int rows;
	private Piece [][] piece;
	
	public Board(int column, int rows) {
		if (rows < 1 || column < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		
		this.column = column;
		this.rows = rows;
		piece = new Piece[rows][column];
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRows() {
		return rows;
	}
	
	public Piece piece (int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return piece[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(therIsAPiece(position)) {
		throw new BoardException("There is already a piece in this place.");
		}
		
		
		this.piece [position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		if(piece(position) == null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position = null;
		piece[position.getRow()][position.getColumn()] = null;
		return aux;
		
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows  && column >= 0 && column < this.column;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean therIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null;
	}

}
