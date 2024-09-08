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
		
		while(!cm.getCheckMate()) {
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
		
		if(cm.getPromoted() != null) {
			System.out.println("Enter piece for promotion: B/N/R/Q");
			String type = entrada.nextLine().toUpperCase();
			while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
				System.out.println("Invalid value! Enter piece for promotion: B/N/R/Q");
				type = entrada.nextLine().toUpperCase();
			}
			cm.replacePromotedPiece(type);
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
		
		UI.clearScreen();
		UI.printMatch(cm, captured);
	
	}

}
