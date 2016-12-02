package TicTacToe;

public class BoardGame {
	
	private String[][] boardArray = new String[3][3];
	
	public BoardGame(){
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				this.boardArray[x][y] = "-";
			}
		}
	}
	
	public int movesLeft(){
		int countMoves = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(boardArray[i][j] == "-")
					countMoves++;
			}
		}
		return countMoves;
	}
	
	public int winnerCheck(){
		int winner = 3;
		
		//Check Rows
		for(int i=0; i<3;i++){
			if(boardArray[i][0] == "x" && boardArray[i][0] == boardArray[i][1] && boardArray[i][2] == boardArray[i][0]){
				winner = 1;
			}else if(boardArray[i][0] == "o" && boardArray[i][0] == boardArray[i][1] && boardArray[i][2] == boardArray[i][0]){
				winner = 2;
			}
		}
		
		return winner;
	}

	public void setBoardArray(int position, int player){
		//set position based on player
		
		String move;
		
		if(player == 1){
			move = "x";
		}else{
			move = "o";
		}
		switch(position){
			case 1:	boardArray[0][0] = move; 
					break;
			case 2: boardArray[0][1] = move;
					break;
			case 3: boardArray[0][2] = move;
					break;
			case 4: boardArray[1][0] = move;
					break;
			case 5: boardArray[1][1] = move;
					break;
			case 6: boardArray[1][2] = move;
					break;
			case 7: boardArray[2][0] = move;
					break;
			case 8: boardArray[2][1] = move;
					break;
			case 9: boardArray[2][2] = move;
					break;
			default: //do nothing
				break;
		}
	}
	
	public String getBoardArray(){
		String finalBoard = boardArray[0][0] + " | " + boardArray[0][1] + " | " + boardArray[0][2] +
				"\n" + boardArray[1][0] + " | " + boardArray[1][1] + " | " + boardArray[1][2] +
				"\n" + boardArray[2][0] + " | " + boardArray[2][1] + " | " + boardArray[2][2];
		return finalBoard;
	}
	
}
