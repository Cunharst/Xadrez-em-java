package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPosition;
import chess.chessPiece;


public class Program {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		
		while(true) {
		UI.printBoard(cm.getPiecess());
		System.out.println();
		System.out.println("Source");
		ChessPosition source = UI.readChessPosition(entrada);
		
		System.out.println("Target");
		ChessPosition target = UI.readChessPosition(entrada);
		chessPiece capturedPiece = cm.performChessMove(source,target);
		
		}
		
	
	}

}
