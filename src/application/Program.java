package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;
import chess.chessPiece;


public class Program {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		ChessMatch cm = new ChessMatch();
		
		while(true) {
		try {
			UI.clearScreen();
		
		UI.printBoard(cm.getPiecess());
		System.out.println();
		System.out.println("Source");
		ChessPosition source = UI.readChessPosition(entrada);
		
		System.out.println("Target");
		ChessPosition target = UI.readChessPosition(entrada);
		chessPiece capturedPiece = cm.performChessMove(source,target);
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
