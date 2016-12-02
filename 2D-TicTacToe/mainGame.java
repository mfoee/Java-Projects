package TicTacToe;
import java.util.*;
import java.util.Scanner;

public class mainGame {
	
	
	public static void nextMove(BoardGame x, int player){
		int position=0;
		Scanner user_input = new Scanner(System.in);
		position = user_input.nextInt();
		x.setBoardArray(position, player);
		System.out.println(x.getBoardArray());
	}
	
	public static void Start(BoardGame x){
		System.out.println("Let's begin: Player1 (x) and Player2 (o)");
		System.out.println("Please use number 1-9 to indicate your move.");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello World");

		BoardGame newGame = new BoardGame();
		
//		Scanner user_input = new Scanner(System.in);
//		int numOfPlayer = 0;
//		boolean validPlayer = true;
//		System.out.println("1 Player or 2 Player?");
//		do{
//			numOfPlayer = user_input.nextInt();
//			if(numOfPlayer != 2 || numOfPlayer !=1){
//				System.out.println("Invalid Entry! Please enter either '1' or '2'.");
//				numOfPlayer = user_input.nextInt();
//			}else{
//				validPlayer = false;
//			}
//		}while(validPlayer);
//		
//		user_input.close();
		int movesRemaining=1, winner = 3;
		int move = 1;
		
		Start(newGame);
		while(movesRemaining != 0 && winner != 0){
			nextMove(newGame, move);
			if(move == 1){
				move = 2;
			}else{
				move = 1;
			}
			movesRemaining = newGame.movesLeft();
			winner = newGame.winnerCheck();
			System.out.println(winner);
		}
		
		
	}

}
