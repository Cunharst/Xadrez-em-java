package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;
import chess.ChessPiece;


public class Program {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<ChessPiece>();
		
		while(true) {
		try {
			UI.clearScreen();
		
		UI.printMatch(cm, captured);
		System.out.println();
		System.out.println("Source");
		ChessPosition source = UI.readChessPosition(entrada);
		
		boolean [][] possibleMoves = cm.possibleMoves(source);
		UI.clearScreen();
		UI.printBoard(cm.getPiecess(), possibleMoves);
		
		System.out.println("Target");
		ChessPosition target = UI.readChessPosition(entrada);
		ChessPiece capturedPiece = cm.performChessMove(source,target);
		
		if(capturedPiece != null) {
			captured.add(capturedPiece);
		}
		}
		catch (ChessException e) {
		System.out.println(e.getMessage());
		entrada.nextLine();
		}
		
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			entrada.nextLine();
			}
		}
		
	
	}

}
