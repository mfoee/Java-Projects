package TicTacToe;
import java.util.*;
import java.util.Scanner;

public class mainGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Hello World");

		BoardGame start = new BoardGame();
		
		Scanner user_input = new Scanner(System.in);;
		int numOfPlayer = 0;
		boolean validPlayer = true;
		System.out.println("1 Player or 2 Player?");
		while(validPlayer){
			numOfPlayer = user_input.nextInt();
			if(numOfPlayer != 2 || numOfPlayer !=1){
				System.out.println("Invalid Entry");
				numOfPlayer = user_input.nextInt();
			}else{
				validPlayer = false;
			}
		}
		
		System.out.println(numOfPlayer);
	}

}
